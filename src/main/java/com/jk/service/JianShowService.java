package com.jk.service;

import com.jk.bean.ProductCopy;
import com.jk.bean.Search;
import java.util.List;

public interface JianShowService {
    /**
     *   查询商品分类
     */

    ProductCopy queryThird(Integer id);

    List<ProductCopy> aaa(Integer id);

    List<Search> search(Search search);

    List<Search> getMarkByIdClass2(Integer id);
}
