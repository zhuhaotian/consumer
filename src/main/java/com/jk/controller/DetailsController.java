/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DetailsController
 * Author:   SWORD
 * Date:     2019/1/24 17:25
 * Description: 产品详情
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.Info;
import com.jk.bean.ShopCar;
import com.jk.bean.Sku;
import com.jk.bean.User;
import com.jk.service.DetailsService;
import com.jk.utils.Constant;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈产品详情〉
 *
 * @author SWORD
 * @create 2019/1/24
 * @since 1.0.0
 */
@Controller
@RequestMapping("details")
public class DetailsController {
    @Resource
    private RedisTemplate<String, List<ShopCar>> redisTemplate;

    @Resource
    private DetailsService detailsService;

    @RequestMapping("detailsByCpId")
    public String detailsByCpId(Integer shpid,ModelMap model){
        model.addAttribute("shpid",shpid);
        return "details";
    }

    @RequestMapping("querydetails")
    @ResponseBody
    public List querydetails(Integer shpid){
        List list = detailsService.querydetails(shpid);
        return list;
    }

    @RequestMapping("queryimgdetails")
    @ResponseBody
    public List queryimgdetails(Integer shpid){
        List list = detailsService.queryimgdetails(shpid);
       // System.out.println(list);
        return list;
    }

    @RequestMapping("querySkuById")
    @ResponseBody
    public Sku querySkuById(Integer skuId){
        Sku sku = detailsService.querySkuById(skuId);
        return sku;
    }

    //添加到仓库
    @RequestMapping("insertGoods")
    @ResponseBody
    public void insertGoods(ShopCar shopCar, HttpServletResponse response,HttpServletRequest request, HttpSession session){

        List<ShopCar> list = new ArrayList<>();
        User  user= (User)session.getAttribute("user111");
        ShopCar shopCar1 =null;
        if(user==null){
            //没登录将生成的uuId 存入cooik
            setCookie(response,3600, Constant.uuid);
            //判断redis是否存在KEy
            if(redisTemplate.hasKey(Constant.uuid)){
                //直接取出key对应的value
                list = redisTemplate.opsForValue().get(Constant.uuid);
                //使用iterator()迭代遍历
                Iterator<ShopCar> iterator = list.iterator();
                //判断是否有下个元素
                if(iterator.hasNext()){
                    //当前循环到的对象
                    shopCar1 = iterator.next();
                    //如果redis中对象有与传过来的对象sku名称一致的
                    if(shopCar1.getSku_mch().equals(shopCar.getSku_mch())){
                        //修改redis仓库的数量 加上前台传过来的数量
                        shopCar1.setTjshl(shopCar1.getTjshl()+shopCar.getTjshl());
                        //将之前的对象移除
                        iterator.remove();
                        //将新的数据存入到list
                        list.add(shopCar1);

                        //如果redis中对象有与传过来的对象sku名称不一致
                    }else{
                        list.add(shopCar);
                    }
                }
                //将该集合存放到redis中
                redisTemplate.opsForValue().set(Constant.uuid,list,30,TimeUnit.MINUTES);
                //如果不存在该Key
            }else{
                //直接将对象存到list中
                list.add(shopCar);
                //将该集合存放到redis中
                redisTemplate.opsForValue().set(Constant.uuid,list,30,TimeUnit.MINUTES);
            }
        }else {
            //如果登陆   获取到用户id
            shopCar.setYh_id(user.getId());
            //判断cookie中key是否存在
            //获取到所有的cookie
            Cookie[] cookies = request.getCookies();
            //判断cookie不为空
            if(cookies!=null){
               //遍历cookies
                for (Cookie cookie : cookies) {
                    //如果cookie的名称与你存入的cookie名称相同
                    if(cookie.getName().equals(Constant.uuid)){
                        String value = cookie.getValue();
                        // 判断redis中该key是否存在
                        //如果存在
                        if(redisTemplate.hasKey(Constant.uuid)){
                            //直接去KEY对应的value
                            list = redisTemplate.opsForValue().get(Constant.uuid);
                            //迭代器遍历
                            Iterator<ShopCar> iterator = list.iterator();
                            //判断是否有下个元素
                            if(iterator.hasNext()){
                                //当前循环到的对象
                                shopCar1 = iterator.next();

                                //判断user专属的key是存在
                                //如果存在   就合并
                                //如果不存在  就去数据库查 然后合并 并缓存到redis中
                                if(redisTemplate.hasKey(Constant.userKey+user.getId())){
                                   list = redisTemplate.opsForValue().get(Constant.userKey+user.getId());
                                 //迭代遍历
                                    Iterator<ShopCar> iterator1 = list.iterator();
                                    //判断是否有下个元素
                                    if(iterator1.hasNext()){
                                        //当前元素
                                        ShopCar next = iterator1.next();
                                        if(next.getSku_mch().equals(shopCar.getSku_mch())){
                                            //修改该对象数量    加新传过来的数量
                                            shopCar1.setTjshl(shopCar1.getTjshl()+shopCar.getTjshl());
                                            //移除当前元素
                                            iterator.remove();
                                            //存到List集合
                                            list.add(shopCar1);
                                        }
                                    }

                                }
                                //查询购物车全部商品
                                List<ShopCar> shop = detailsService.getShopCar(user);
                                Iterator<ShopCar> itdab = shop.iterator();
                                if(itdab.hasNext()){
                                    ShopCar next = itdab.next();
                                    //如果redis中对象有与mysql数据库中已存在的对象sku名称一致
                                    if(shopCar1.getSku_mch().equals(next.getSku_mch())){
                                        //修改数据库商品的数量
                                        next.setTjshl(next.getTjshl()+shopCar1.getTjshl());
                                        detailsService.updateShopCar(next);
                                        //重新从数据库查询数据
                                        List<ShopCar> shop1 = detailsService.getShopCar(user);
                                        redisTemplate.delete(Constant.userKey+user.getId());
                                        redisTemplate.opsForValue().set(Constant.userKey+user.getId(),shop1,30,TimeUnit.MINUTES);
                                        setCookie(response,3600,Constant.userKey+user.getId());
                                    }else{
                                        //如果redis中对象有与mysql数据库中不存在的对象sku
                                        //新增mysql数据库
                                        detailsService.addShopCar(next);
                                        List<ShopCar> shop1 = detailsService.getShopCar(user);
                                        redisTemplate.delete(Constant.userKey+user.getId());
                                        redisTemplate.opsForValue().set(Constant.userKey+user.getId(),shop1,30,TimeUnit.MINUTES);
                                        setCookie(response,3600,Constant.userKey+user.getId());
                                    }
                                }
                            }
                        }else{
                            //redis中不存在该key     去数据库查询   缓存到redis中
                            List<ShopCar> shopCar2 = detailsService.getShopCar(user);
                            redisTemplate.opsForValue().set(Constant.userKey+user.getId(),shopCar2,30,TimeUnit.MINUTES);
                        }
                    }
                }
            }
            redisTemplate.opsForValue().set(Constant.userKey+user.getId(),list,30,TimeUnit.MINUTES);
            List<ShopCar> shopCar2 = detailsService.getShopCar(user);
            detailsService.addShopCar(shopCar);
            List<ShopCar> shopCar3 = detailsService.getShopCar(user);
            redisTemplate.opsForValue().set(Constant.userKey+user.getId(),shopCar3,30,TimeUnit.MINUTES);
            setCookie(response,3600,Constant.userKey+user.getId());
        }
    }

    private void setCookie(HttpServletResponse response, int time, String cookieKey) {

        Cookie cookie = new Cookie(Constant.uuid, cookieKey);
        //设置在根目录就可以访问
        cookie.setPath("/");
        //设置过期时间
        cookie.setMaxAge(time);
        //将自定义的cookie放到响应头  存放在浏览器内存中
        response.addCookie(cookie);

    }

    //测试  Redis 工具类
   // @RequestMapping("mm")
   // @ResponseBody
   // public String mm(){

    //    redisTemplate.opsForValue().set("aaa","hello word",40, TimeUnit.MINUTES);
      //  return "success";
  //  }

    //查询redis
    @ResponseBody
    @RequestMapping("getShop")
    public List<ShopCar> getShop(HttpServletRequest request,HttpSession session){
        List<ShopCar> list =null;
        User user = (User) session.getAttribute("user111");
        //获取所有的KEY
        Cookie[] cookies = request.getCookies();
        //判断用户是否登录
        if(user==null){
            if(cookies!=null){
             //循环遍历判断cookies对应的Key是否存在
                for (Cookie cookie : cookies) {
                    if(cookie.getName().equals(Constant.uuid)){
                        //如果cookie中存在key 查看Redis是否也存在key
                        if(redisTemplate.hasKey(Constant.uuid)){
                            list = redisTemplate.opsForValue().get(Constant.uuid);
                        }
                    }
                }
            }
        }else{
            //如果用户登录
            //先去redis中去查，判断cookie是否为空
            //如果cookie不为空
            if(cookies !=null){
                //循环遍历判断cookies对应的Key是否存在
                for (Cookie cookie : cookies) {
                    if(cookie.getName().equals(Constant.userKey+user.getId())){
                        //如果cookie中存在key    判断redis中是否存在
                        if(redisTemplate.hasKey(Constant.userKey+user.getId())){
                            list=redisTemplate.opsForValue().get(Constant.userKey+user.getId());
                        }
                    }else{
                        //cookie为空   直接去mysql查询
                        list = detailsService.getShopCar(user);
                        //再将数据缓存至redis中
                        redisTemplate.opsForValue().set(Constant.userKey+user.getId(),list,30,TimeUnit.MINUTES);
                    }
                    }
            }else{
                //cookie为空   直接去mysql查询
                list = detailsService.getShopCar(user);
                //再将数据缓存至redis中
                redisTemplate.opsForValue().set(Constant.userKey+user.getId(),list,30,TimeUnit.MINUTES);
            }
        }
        if(list !=null){
            for (ShopCar car : list) {
                car.setHj(car.getTjshl()*car.getSkuJg());
            }
        }
        System.out.println(list);
        return list;
    }

    @ResponseBody
    @RequestMapping("addCount")
    public String addCount(Integer id,Integer tjshl,Double skuJg){
        detailsService.addCount(id,tjshl,skuJg);
        return "1";
    }
    @ResponseBody
    @RequestMapping("jianCount")
    public String jianCount(Integer id,Integer tjshl,Double skuJg){
        detailsService.jianCount(id,tjshl,skuJg);
        return "1";
    }

    //结算
    @ResponseBody
    @RequestMapping("jieSuanCheckPrice")
    public Double jieSuanCheckPrice(String ids){

        return detailsService.jieSuanCheckPrice(ids);
    }

}
