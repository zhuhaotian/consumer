package com.jk.controller;

import com.jk.bean.Title;
import com.jk.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("tit")
public class TitleController {
    @Resource
    TitleService service;
    @RequestMapping("toshow")
    public  String toShow(String name){

        return name;
    }
    @ResponseBody
    @RequestMapping("getTitle")
    public List<Title> getTitle(){
        List<Title> title = service.getTitle();
        return title;
    }
}
