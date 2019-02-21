package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jk.bean.Mallsku;
import com.jk.bean.Sku;
import com.jk.client.esClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("es")
public class esController {
    @Autowired
    private esClient esClient;

    @RequestMapping("esClient")
    public String esClients(Mallsku Mallsku, Model model){
        List ss =  esClient.esarr(Mallsku);
        model.addAttribute("lists",ss);
     return "goods";
    }

}
