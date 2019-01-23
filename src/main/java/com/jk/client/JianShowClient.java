package com.jk.client;

import com.jk.bean.TradeMark;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("producer")
public interface JianShowClient {

    @RequestMapping("/stock/getTradeMarkById")
    List<TradeMark> getTradeMarkById(@RequestParam("id") Integer id);

}
