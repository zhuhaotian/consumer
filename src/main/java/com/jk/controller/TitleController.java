package com.jk.controller;

import com.jk.bean.Title;
import com.jk.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    /**
     * 获取session 里面的值
     */
    @RequestMapping("getSeValue")
    @ResponseBody
    public String getSeValue(HttpServletRequest request){

        String loginName = (String)request.getSession().getAttribute("login");
        System.err.println("-----------------"+loginName);
        return loginName;
    }
}
