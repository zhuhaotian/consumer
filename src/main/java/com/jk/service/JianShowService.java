package com.jk.service;

import com.jk.bean.ProductCopy;

import java.util.List;

public interface JianShowService {
    /**
     *   查询商品分类
     */
    ProductCopy queryThird(Integer id);

    List<ProductCopy> aaa(Integer id);

    List<ProductCopy> queryPrice(Integer id);
}
