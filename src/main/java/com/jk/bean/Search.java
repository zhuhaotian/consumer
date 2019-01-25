package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Search implements Serializable {

    /**
     * 商品id
     */
    private Integer ppId;
    private Integer flbh1;
    private Integer flbh2;
    private Double startPrice;
    private Double endPrice;
    /**
     * 销量
     */
    private Integer skuXl;

    /**
     *正序倒叙 所以有值代表倒叙，null随机
     */
    private Integer creatTime;

    /**
     * 用来排序
     */
    private Integer price;
    /**
     * 临时表
     */
    private String shp_mch;
    private String sh_tp;
    private Double jg;
    private String kcdz;
    //private String shp_sx;
    private String sku_xl;
    private String shxzh;
    private String shxm_mch;
    /**
     * 品牌名称
     */
    private String ppmch;
    /**
     * class1naem
     */
    private String class1Name;
    /**
     * class2naem
     */
    private String class2Name;
}
