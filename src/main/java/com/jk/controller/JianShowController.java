package com.jk.controller;

import com.jk.bean.TradeMark;
import com.jk.bean.productCopy;
import com.jk.client.JianShowClient;
import com.jk.service.JianShowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("jianShow")
public class JianShowController {

    @Resource
    JianShowService jianShowService;

    @Resource
    JianShowClient jianShowClient;

    @RequestMapping("toJian")
    public String toJian(){

        return "jianshow";
    }

    @RequestMapping("queryBrand")
    @ResponseBody
    public List<TradeMark> queryBrand(String id){
        List<TradeMark> tradeMarkById = jianShowClient.getTradeMarkById(id);
        return tradeMarkById;
    }

    /**
     * 查询 商品分类
     */
    @RequestMapping("queryThird")
    @ResponseBody
    public List<productCopy> queryThird(Integer id){

        List<productCopy> list=jianShowService.queryThird(id);
        return list;
    }


}
