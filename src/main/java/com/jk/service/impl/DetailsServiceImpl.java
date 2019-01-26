package com.jk.service.impl;

import com.jk.bean.Info;
import com.jk.bean.User;
import com.jk.mapper.DetailsMapper;
import com.jk.service.DetailsService;
import com.jk.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    private DetailsMapper detailsMapper;

    @Override
    public List querydetails(Integer shpid) {

        return detailsMapper.querydetails(shpid);
    }

    @Override
    public List<Info> insertGoods(Info info, HttpServletRequest request, HttpSession session) {
        User userName = (User)session.getAttribute("user111");

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            System.err.println("------------"+cookie.getValue());

            /*if(){
                String loginInfo = cookie.getValue();
                String username = loginInfo.split(",")[0];
                String password = loginInfo.split(",")[1];
                request.setAttribute("username", username);
                request.setAttribute("password", password);
            }*/
        }
        // if(userName !=null){

        // }
        // if()
        //Cookie cookie=new Cookie(Constant.remember_pwd);
        // detailsMapper.insertGoods(info)
        return null;
    }



}
