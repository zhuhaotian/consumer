package com.jk.service;

import com.jk.bean.ShopCar;
import com.jk.bean.Sku;
import com.jk.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface DetailsService {

    List querydetails(Integer shpid);
     //添加购物车
     void insertGoods(ShopCar shopCar, HttpServletResponse response, HttpServletRequest request, HttpSession session);

    List queryimgdetails(Integer shpid);

    List<ShopCar> getShopCar(User user);

    void updateShopCar(ShopCar next);

    void addShopCar(ShopCar next);

    ShopCar getShop(ShopCar sh);

    Sku querySkuById(Integer skuId);

    void addCount(Integer id, Integer tjshl, Double skuJg);


    void jianCount(Integer id, Integer tjshl, Double skuJg);

    Double jieSuanCheckPrice(String ids);

    void deletesShopCar(String ids);

    void addShopCar2(List<ShopCar> list2);

    List<ShopCar> getShopCar2();

    ShopCar getShopCar33(List<ShopCar> list2);

    void updateShop(List<ShopCar> list2);


    void deletesShopCar2(Integer id);
}
