/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginController
 * Author:   SWORD
 * Date:     2019/1/23 14:20
 * Description: 登录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.User;
import com.jk.client.LoginClient;

import com.jk.service.TitleService;
import com.jk.service.LoginService;
import com.jk.service.impl.email;
import com.jk.utils.Constant;
import com.jk.utils.HttpClient;
import com.jk.utils.QueryParam;
import com.jk.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录〉
 *
 * @author SWORD
 * @create 2019/1/23
 * @since 1.0.0
 */
@Controller
public class LoginController {

    @Resource
    private LoginClient client;

    @Resource
    private TitleService titleService;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private LoginService loginService;

    @Autowired
    private email mailService;

    private String title="你好，邮箱发送成功";

    @RequestMapping("getQuery")
    @ResponseBody
    public String getQuery(User user, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        User userData = client.queryloginuser(user);
       // System.err.println("userData"+userData);
        if (userData == null) {
            return "0";   //用户名  密码不正确
        }else{
            session.setAttribute("user111",userData);
            Cookie cookie = new Cookie(Constant.remember_pwd,userData.getYhMch()+Constant.splitsperator+userData.getYhMm());
            cookie.setMaxAge(60*60*24*7);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "1";
        }
    }

    @RequestMapping("removeUser")
    public String zhuxiao(HttpSession session, ModelMap modelMap){
        session.removeAttribute("user111");
        modelMap.addAttribute("user",session.getAttribute("user111"));
        return "login";
    }

    @RequestMapping("queryUserExist")
    @ResponseBody
    public String queryUserExist(HttpSession session){
        User user = (User)session.getAttribute("user111");
        if(user ==null){
            return "0";  //为空
        }else{
            return "1";
        }
    }

    /**
     * 短信验证接口
     */
    @RequestMapping("getRandomCode")
    @ResponseBody
    public Result getRandomCode(QueryParam queryParam,HttpSession session){
        Result result=new Result();
        User phoneState=titleService.selectPhoneState(queryParam.getPhone_no());
        session.setAttribute("user111",phoneState);
        if(phoneState.getState()==1){  //正常
            //每次都从redis中取一下当前手机号 如果有值 说明是刷新界面多次获取验证码
            boolean ao=redisTemplate.hasKey(Constant.multiple_code+queryParam.getPhone_no());

            //两次获取验证码的时间没有超过40s
            if(ao){
                result.setCode(2);   //对象已存在
            }else{
                result.setCode(1);   //不存在
                //产生一个六位的短信验证码
                int rdm=(int) (Math.random()*899999+100000);
                //把验证码放到 redis 缓存中
                redisTemplate.opsForValue().set(Constant.phone_code+queryParam.getPhone_no(), rdm+"", 5, TimeUnit.MINUTES);

                System.out.println(rdm);
                // 调用接口发送验证码(60s不能重复发送 24h只能发三次)
                Map<String,Object> params=new HashMap<>();
                params.put("key","c92f6b86f77d5ba2350b8882ae5d6f94");  // 	接口名称上方查看
                params.put("mobile",queryParam.getPhone_no());  // 	接收短信的手机号码
                params.put("tpl_id","124696");  // 	短信模板ID
                params.put("tpl_value","%23code%23%3d"+rdm);  // 	变量名和变量值对

                String sendGet = HttpClient.sendGet("http://v.juhe.cn/sms/send", params);
                //把当前的手机号存到redis中 并设置40秒的过期时间  判断是否多次登录
                redisTemplate.opsForValue().set(Constant.multiple_code+queryParam.getPhone_no(), "123", 5, TimeUnit.MINUTES);
            }
        }else{
            result.setCode(0);    //在黑名单
        }

        return result;
    }

    /**
     * 去手机号登录页面
     */
    @RequestMapping("toPhoneLogin")
    public String toPhoneLogin(){
        return "phoneLogin";
    }


    /**
     *  校验验证码是否正确
     */
    @RequestMapping("checkCode")
    @ResponseBody
    public String checkCode(QueryParam queryParam, HttpSession session){
        //用户当前输入的验证码
        String verify_code = queryParam.getVerify_code();
        // 比对验证码
        String codeFormRedis = redisTemplate.opsForValue().get(Constant.phone_code+queryParam.getPhone_no());
        //如果用户输入的验证码是正确的
        //登录成功
        if(codeFormRedis!=null && codeFormRedis.equals(verify_code)){
            // 登录成功 根据手机号 查询出用户的信息 保存到session
            User user=titleService.getUserByPhone(queryParam.getPhone_no());
            //必须以user为key 不然拦截器会认为没有登录
            session.setAttribute("user", user);
            redisTemplate.delete(Constant.phone_code+queryParam.getPhone_no());
            return "1";  //校验成功
        }
        else{
           // int code = (int) (Math.random() * 8999 + 1000);
            Long count = redisTemplate.opsForValue().increment(Constant.phone_code + queryParam.getPhone_no(), 1);
            if(count>3){
                Duration between = Duration.between(LocalDateTime.now(), LocalDate.now().plusDays(1).atTime(0, 0, 0));
                redisTemplate.expire(Constant.phone_code + queryParam.getPhone_no(),between.toMinutes(), TimeUnit.SECONDS);
                return "4";//发送验证码次数以达上限
            }
            return "0";   //校验失败
        }
    }



    @RequestMapping("register")
    public String register(){

        return "register";
    }


    //注册
    @ResponseBody
    @RequestMapping("registertwo")
    public String registertwo(User user){
        mailService.sendSimple(user.getTo(),title,title);
        loginService.registertwo(user);
        return "1";
    }
}