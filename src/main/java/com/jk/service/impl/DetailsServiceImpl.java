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
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override   //id   ,数量   skuid  ,
    public List<Info> insertGoods(Info info, HttpServletRequest request, HttpSession session) {
        User userName = (User)session.getAttribute("user111");

        Cookie[] cookies = request.getCookies();

            if(userName.getYhMch()==null){   // 没有登录    以游客身份储存

                SimpleDateFormat simp = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
                String date = simp.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳

            }

        // if(userName !=null){

        // }
        // if()
        //Cookie cookie=new Cookie(Constant.remember_pwd);
        // detailsMapper.insertGoods(info)
        return null;
    }



}
