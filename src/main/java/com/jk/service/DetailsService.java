package com.jk.service;

import com.jk.bean.Info;
import com.jk.bean.ShopCar;
import com.jk.bean.Sku;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface DetailsService {

    List querydetails(Integer shpid);

    Sku querySkuById(Integer skuId);
     //添加购物车
     void insertGoods(ShopCar shopCar, HttpServletResponse response, HttpServletRequest request, HttpSession session);


    List queryimgdetails(Integer shpid);
}
