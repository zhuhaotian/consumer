package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ShopCar implements Serializable{

   private Integer Id;

   private String sku_mch;   //sku名称

   private Integer tjshl;   //添加数量

   private Integer  hj;   //合计

   private Integer yh_id;    //用户id

   private Integer  shp_id;   //商品id

   private Date chjshj;   //创建时间

   private Integer sku_id;   //sku_id

   private String shp_tp;   //商品图片

   private String shfxz;

   private String kcdz;

}
