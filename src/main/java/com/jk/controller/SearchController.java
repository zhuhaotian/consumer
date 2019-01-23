package com.jk.controller;

import com.jk.bean.Class2;
import com.jk.client.SearchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private SearchClient searchClient;


    @RequestMapping("Search")
    public String Search(){

     return "imgTrends";
    }
    //调用生产者所有的商品
    @ResponseBody
    @RequestMapping("Searchtwo")
    public List Searchtwo(){
        List list =searchClient.Searchtwo();
        System.out.println(list);
     return list;
    }
    @ResponseBody
    @RequestMapping("Searchthree")
    public List Searchthree(@RequestParam("id") Integer id){
     List list =searchClient.Searchthree(id);
        System.out.println(list);
     return list;
    }

    @RequestMapping("toView")
    public String tojianshow(Integer id, ModelMap model){
        System.out.println(id);
        model.addAttribute("id",id);
     return "jianshow";
    }




}
