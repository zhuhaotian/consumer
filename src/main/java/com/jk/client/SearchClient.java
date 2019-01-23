package com.jk.client;

import com.jk.bean.Class2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("producer")
public interface SearchClient {

    @RequestMapping("/stock/queryClass1")
    public List Searchtwo();


    @RequestMapping("/stock/getClass2ByFlbh1")
    public List Searchthree(@RequestParam("id") Integer id);



}
