package com.jk.bean;

import lombok.Data;

@Data
public class ProductCopy extends Product{

    /**
     * 分类名称1
     */
    private String flmch1;
    /**
     * 分类名称2
     */
    private String flmch2;

    private String shp_mch;//(商品名称)  String(100)

    private Integer jg;  //价格

    private String kcdz;   //库存地址

    private Integer kcxl;  //库存


}
