package com.jk.mapper;

import com.jk.bean.ProductCopy;

import java.util.List;

public interface JianShowMapper {

    //根据 查询
    ProductCopy queryThird(Integer id);

    List<ProductCopy> aaa(Integer id);

    List<ProductCopy> queryPrice(Integer id);
}
