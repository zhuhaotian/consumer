package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.ShopCar;
import com.jk.bean.Sku;
import com.jk.bean.User;
import com.jk.service.DetailsService;
import com.jk.utils.Constant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("good")
public class GoodController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private DetailsService detailsService;

    @RequestMapping("toGoods")
    public String toGoods(){

        return "shop";
    }
    /*@RequestMapping("toshop")
    public String toshop(){

        return "shop";
    }*/

    //删除    list = redisTemplate.opsForValue().get(Constant.userKey+user.getId());
    @RequestMapping("deleteGoodss")
    @ResponseBody
    public String  deleteGoodss(Integer indexs, HttpSession session){
        User user= (User)session.getAttribute("user111");
            redisTemplate.opsForList().trim(Constant.userKey+user.getId(),indexs+1,50);
           // redisTemplate.opsForList().trim(key, start, 50);

        return null;
    }


}
