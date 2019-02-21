package com.jk.controller;

import com.jk.bean.Video;
import com.jk.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CartController {

    @Resource
    private CartService cartService;


    //视频
    @ResponseBody
    @RequestMapping("video")
    public Video video(Integer id){
        Video video = cartService.video(id);
       return video;
    }


}
