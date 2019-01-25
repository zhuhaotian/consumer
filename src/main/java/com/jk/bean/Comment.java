package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
private Integer id;      //(编号)  
private Integer yh_id;   //(用户id)     
private String  plnr;    //(评论内容)
private Date    plshj;   //(平路时间) 
private String hpjb;    //(好评级别)  
private Integer sku_id;  //(skuid)
private String sku_mch; //(sku名称)
private Integer shp_id;  //(商品id) 
private String  shp_mch; //(商品名称)
private Integer dd_id;   //(订单id)
private String  kcdz;
private String  url;
private String  yh_mch;
}
