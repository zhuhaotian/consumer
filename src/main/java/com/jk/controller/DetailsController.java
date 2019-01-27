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
    public String tojianshow(Integer shpid,ModelMap model){
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

    @RequestMapping("insertGoods")
    @ResponseBody
    public List<Info> insertGoods(ShopCar shopCar, HttpServletResponse response,HttpServletRequest request, HttpSession session){

         detailsService.insertGoods(shopCar,response,request,session);
        return null;
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
    public List<ShopCar> getShop(HttpServletRequest request){
        List<ShopCar> list =null;
       if(redisTemplate.hasKey(Constant.tourist_key + Constant.uuid)){  //UUID_392ebe9e-8445-46a8-baa7-f76f9080d0fb
        list = redisTemplate.opsForValue().get(Constant.tourist_key + Constant.uuid);
       }
       System.out.println(list);
        return list;
    }

}