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
import com.jk.bean.User;
import com.jk.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private RedisTemplate<String, String>redisTemplate;

    @Autowired
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

    @RequestMapping("insertGoods")
    @ResponseBody
    public List<Info> insertGoods(Info info, HttpServletRequest request,HttpSession session){

        List<Info>list= detailsService.insertGoods(info,request,session);
        return list;
    }

    //测试  Redis 工具类
    @RequestMapping("mm")
    @ResponseBody
    public String mm(){

        redisTemplate.opsForValue().set("aaa","hello word",40, TimeUnit.MINUTES);
        return "success";
    }


}