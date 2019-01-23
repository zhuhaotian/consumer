package com.jk.service;

import com.jk.bean.productCopy;

import java.util.List;

public interface JianShowService {
    /**
     *   查询商品分类
     */
    List<productCopy> queryThird(Integer id);
}
