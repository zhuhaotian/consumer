package com.jk.mapper;

import com.jk.bean.ShopCar;
import com.jk.bean.User;
import com.jk.bean.Sku;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

   

    @Select("select * from t_mall_shoppingcar where sku_id=#{sku_id} and shp_id = #{shp_id} and yh_id = #{yh_id}")
    ShopCar getSkuSpu(ShopCar next);

    void updateShopCar(ShopCar next);

    List<ShopCar> getShopCar(Integer id);

    @Update("update t_mall_shoppingcar set tjshl = #{tjshl} where id = #{id}")
    void updateTjshl(ShopCar next);

    void addShopCar(ShopCar next);


    ShopCar getShop(Integer shp_id);

    @Select("select * from t_mall_sku where id =#{skuId}")
    Sku getSkuById(@Param("skuId") Integer skuId);
}
