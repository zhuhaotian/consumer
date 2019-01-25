/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Info
 * Author:   SWORD
 * Date:     2019/1/24 20:34
 * Description: 商品详情
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品详情〉
 *
 * @author SWORD
 * @create 2019/1/24
 * @since 1.0.0
 */
@Data
public class Info implements Serializable {
        private Integer sku_id;

    /**
     * 版本
     */
    private Integer shp_bb;
    /**
     * 服务
     */
    private Integer shp_fw;


/**
 * 业务字段
 */
        //版本
        private String banben;
        //价格
        private Integer sku_jg;
        //服务
        private String fuwu;


}