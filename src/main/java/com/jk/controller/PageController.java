/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PageController
 * Author:   SWORD
 * Date:     2019/1/23 13:58
 * Description: 跳转页面
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈跳转页面〉
 *
 * @author SWORD
 * @create 2019/1/23
 * @since 1.0.0
 */
@Controller
public class PageController {

    @RequestMapping("tologin")
    public String tologin(){
        return "login";
    }

    /**
     *   去展示页面
     */
    @RequestMapping("toindex")
    public String toindex(HttpSession session,HttpServletRequest request){

      /*  User loginName = (User)session.getAttribute("login");
        if(loginName !=null){
           session.setAttribute("user",loginName.getYhMch());
       }else{
           session.setAttribute("user","xxx");
       }*/

        return "imgTrends";
    }
}