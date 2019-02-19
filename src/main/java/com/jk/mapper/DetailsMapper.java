package com.jk.mapper;

import com.jk.bean.ShopCar;
import com.jk.bean.User;
import com.jk.bean.Sku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DetailsMapper {
    List querydetails(@Param("shpid") Integer shpid);

    List queryimgdetails(@Param("shpid") Integer shpid);

    //从购物车 中查询 出全部的商品信息
    List<ShopCar> queryGoodsByUser(User userName);

    //修改数据库商品  的数量
    void updateTjshlBy(ShopCar next1);

    //新增 mysql  数据库
    void addShopGoods(ShopCar next1);

    Sku querySkuById(Integer skuId);
}
