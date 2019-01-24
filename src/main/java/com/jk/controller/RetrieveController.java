package com.jk.controller;

import com.jk.bean.Search;
import com.jk.bean.TradeMark;
import com.jk.client.RetrieveService;
import com.jk.service.JianShowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("retrieve")
public class RetrieveController {

    @Resource
    private RetrieveService retrieveService;

    @Resource
    private JianShowService jianShowService;
    @RequestMapping("toJianShow")
    public String toJianShow(){
        return "jianshow";
    }

    @RequestMapping("getMarkById")
    @ResponseBody
    public List<TradeMark> getMarkById(Integer id){
        return retrieveService.getTradeMarkById(id);
    }

    @ResponseBody
    @RequestMapping("search")
    public List<Search> search(Search search){
        List<Search> search1 = jianShowService.search(search);
        System.out.println("输出="+search1);
        return search1;
    }
}
