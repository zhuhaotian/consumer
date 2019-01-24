package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("goods")
public class GoodController {

    @RequestMapping("toGoods")
    public String toGoods(){

        return "goodshow";
    }
}
