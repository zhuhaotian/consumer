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

        return search1;
    }

    @ResponseBody
    @RequestMapping("getMarkByIdClass2")
    public List getMarkByIdClass2(Integer id){
        List markByIdClass2 = jianShowService.getMarkByIdClass2(id);
        return markByIdClass2;
    }

    @ResponseBody
    @RequestMapping("getFiltrate")
    public Search getFiltrate(Search search){
        Search filtrate = jianShowService.getFiltrate(search);
        return filtrate;
    }

    @ResponseBody
    @RequestMapping("getTopPp")
    public Search getTopPp(Integer ppId){
        Search topPp = jianShowService.getTopPp(ppId);
        return topPp;
    }
}
