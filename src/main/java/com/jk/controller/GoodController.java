package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.DetailsService;
import com.jk.utils.Constant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

    //删除    list = redisTemplate.opsForValue().get(Constant.userKey+user.getId());
    @RequestMapping("deleteGoodss")
    @ResponseBody
    public String  deleteGoodsAndRedis(Integer id, HttpSession session){
        User user= (User)session.getAttribute("user111");
        Object o = redisTemplate.opsForValue().get(Constant.userKey + user.getId());

        // redisTemplate.opsForList().trim(key, start, 50);

        return null;
    }


}
