package com.jk.controller;

import com.jk.bean.Mallsku;
import com.jk.client.esClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("es")
public class esController {
    @Autowired
    private esClient esClient;
    @ResponseBody
    @RequestMapping("esClient")
    public List esClients(Mallsku Mallsku){
        List list =  esClient.esarr(Mallsku);
     return list;
    }

}
