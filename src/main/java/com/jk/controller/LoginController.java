/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginController
 * Author:   SWORD
 * Date:     2019/1/23 14:20
 * Description: 登录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.User;
import com.jk.client.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录〉
 *
 * @author SWORD
 * @create 2019/1/23
 * @since 1.0.0
 */
@Controller
public class LoginController {

    @Autowired
    private LoginClient client;

    @RequestMapping("queryloginuser")
    @ResponseBody
    public String LoginUserByYhMchByYhMm(User user, HttpServletRequest request){
        User user1 = client.queryloginuser(user);
        request.getSession().setAttribute("login",user);
        if (user1 != null) {
            return "1";
        }
        return "0";
    }

    @RequestMapping("removeUser")
    public String zhuxiao(HttpServletRequest request){
        request.getSession().removeAttribute("login");
        return "login";
    }
}