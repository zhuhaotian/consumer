package com.jk.controller;

import com.jk.bean.Class2;
import com.jk.bean.Comment;
import com.jk.client.SearchClient;
import com.jk.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class SearchController {
    private static final String UUID = "";
    @Autowired
    private SearchClient searchClient;
    @Autowired
    private SearchService SearchService;

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
    public List Searchthree(@RequestParam("id") Integer id, HttpSession session){
     List list =searchClient.Searchthree(id);
     //   System.err.println("00000"+id);
        session.setAttribute("id",id);
     return list;
    }

    @RequestMapping("toView")
    public String tojianshow(Integer id,Integer class2Id, ModelMap model){
        model.addAttribute("id",id);
        model.addAttribute("class2Id",class2Id);
      //  System.out.println("class1:"+id);
      //  System.out.println("class2:"+class2Id);
        // model.addAttribute("pid",pid);
     return "jianshow";
    }
    //查询评论
    @ResponseBody
    @RequestMapping("comment")
    public List<Comment> comment(Integer id){

        List<Comment> list = SearchService.comment(id);
        for (Comment comment:list){
         if(comment.getYh_id()==0){
           comment.setYh_mch("游客登陆");
         }
        }
        System.out.println(list);
      return list;
    }
    //新增评论
    @ResponseBody
    @RequestMapping("rules")
    public String rules(Comment comment){
        if(comment.getYh_id()==null){
          comment.setYh_id(0);
        }
        SearchService.rules(comment);
     return "1";
    }





}
