package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("good")
public class GoodController {

    @RequestMapping("toGoods")
    public String toGoods(){

        return "shop";
    }
    /*@RequestMapping("toshop")
    public String toshop(){

        return "shop";
    }*/


}
