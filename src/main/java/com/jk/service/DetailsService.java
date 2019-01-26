package com.jk.service;

import com.jk.bean.Info;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface DetailsService {

    List querydetails(Integer shpid);

     //添加购物车
    List<Info> insertGoods(Info info, HttpServletRequest request, HttpSession session);


    List queryimgdetails(Integer shpid);
}
