package com.jk.controller;

import com.jk.bean.*;
import com.jk.client.SearchClient;
import com.jk.service.SearchService;
import com.jk.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class SearchController {

    @Autowired
    private SearchClient searchClient;
    @Autowired
    private SearchService SearchService;
    //redis

    @Resource
    private RedisTemplate<String, List<ShopCar>> redisTemplate;

    @RequestMapping("Search")
    public String Search(){

     return "imgTrends";
    }
    //调用生产者所有的商品
    @ResponseBody
    @RequestMapping("Searchtwo")
    public List Searchtwo(){
        List list =searchClient.Searchtwo();
       // System.out.println(list);
     return list;
    }
    @ResponseBody
    @RequestMapping("Searchthree")
    public List Searchthree(@RequestParam("id") Integer id, HttpSession session){
     List list =searchClient.Searchthree(id);
     //   System.err.println("00000"+id);
        session.setAttribute("id",id);
     return list;
    }

    @RequestMapping("toView")
    public String tojianshow(Integer id,Integer class2Id, ModelMap model){
        model.addAttribute("id",id);
        model.addAttribute("class2Id",class2Id);
      //  System.out.println("class1:"+id);
      //  System.out.println("class2:"+class2Id);
        // model.addAttribute("pid",pid);
     return "jianshow";
    }
    //查询评论
    @ResponseBody
    @RequestMapping("comment")
    public List<Comment> comment(Integer id){
        List<Comment> list = SearchService.comment(id);
        for (Comment comment:list){
         if(comment.getYh_id()==0){
           comment.setYh_mch("游客登陆");
           comment.setShp_mch("这个游客啥也没买还评论");
           comment.setImg("http://md-bucket.oss-cn-beijing.aliyuncs.com/LoLimg/5b12e5bddf2b173b953971e786c5d57b.jpg?Expires=1548389412&OSSAccessKeyId=TMP.AQG5pHe9QWSWHAeDeJKxMbyJ3yep6sDPSBmThrcV7ImlA43VhTrChF9mf0Z7ADAtAhUAjZwQ3utc10LjFkBxnvAq9wLR8f4CFAb_A8z6XZptTtFAIPbYgbj17Uko&Signature=MTBG7ME7jTUrvm0DKIiGt6prePY%3D");
             String img = comment.getImg();
             //System.out.println(img);
         }
        }
      //  System.out.println(list);
      return list;
    }
    //新增评论
    @ResponseBody
    @RequestMapping("rules")
    public String rules(Comment comment){
        if(comment.getYh_id()==null){
          comment.setYh_id(0);
        }
        SearchService.rules(comment);
     return "1";
    }
    //查询购物车
    @ResponseBody
    @RequestMapping("shoppingcart")
    public List shoppingcart(HttpSession session){
        List<ShopCar> list =null;
        User user= (User)session.getAttribute("user111");
        if(redisTemplate.hasKey(Constant.userKey+user.getId())){
            list= redisTemplate.opsForValue().get(Constant.cart);
            System.out.println("在redis中查询");
        }else{
            list =SearchService.shoppingcart();
            redisTemplate.opsForValue().set(Constant.cart,list);
            System.out.println("在数据库中查询");
        }
      return list;
    }




}
