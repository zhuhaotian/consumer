package com.jk.controller;

import com.jk.bean.TradeMark;
import com.jk.bean.ProductCopy;
import com.jk.client.JianShowClient;
import com.jk.service.JianShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("jianShow")
public class JianShowController {

    @Autowired
    JianShowService jianShowService;

    @Autowired
    JianShowClient jianShowClient;

    @RequestMapping("toJian")
    public String toJian(){

        return "jianshow";
    }

    @RequestMapping("queryBrand")
    @ResponseBody
    public List<TradeMark> queryBrand(Integer id){
        List<TradeMark> tradeMarkById = jianShowClient.getTradeMarkById(id);
        return tradeMarkById;
    }

    /**
     * 查询 商品分类
     */
    @RequestMapping("queryThird")
    @ResponseBody
    public ProductCopy queryThird(Integer id){

        ProductCopy list=jianShowService.queryThird(id);
       // System.err.println(list);
        return list;
    }

    @RequestMapping("aaa")
    @ResponseBody
    public List<ProductCopy> aaa(Integer id){

        List<ProductCopy> list= jianShowService.aaa(id);
        return list;
    }

}
