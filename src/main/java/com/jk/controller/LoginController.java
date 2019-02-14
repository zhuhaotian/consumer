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

import com.jk.service.LoginService;
import com.jk.service.impl.email;
import com.jk.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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

    @Autowired
    private LoginClient client;

    @Resource
    private LoginService loginService;

    @Autowired
    private email mailService;

    private String title="你好，邮箱发送成功";

    @RequestMapping("queryloginuser")
    @ResponseBody
    public String LoginUserByYhMchByYhMm(User user, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        User userData = client.queryloginuser(user);

        if (userData == null) {
            return "0";   //用户名  密码不正确
        }else{
            session.setAttribute("user111",userData);
            Cookie cookie = new Cookie(Constant.remember_pwd+userData.getId(),userData.getYhMch()+Constant.splitsperator+userData.getYhMm());
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