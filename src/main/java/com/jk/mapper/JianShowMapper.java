package com.jk.mapper;

import com.jk.bean.ProductCopy;
import com.jk.bean.Search;

import java.util.HashMap;
import java.util.List;

public interface JianShowMapper {

    //根据 查询
    ProductCopy queryThird(Integer id);

    List<ProductCopy> aaa(Integer id);

    List<Search> search(HashMap<String, Object> hashMap);
}
