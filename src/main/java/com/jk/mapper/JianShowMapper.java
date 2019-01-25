package com.jk.mapper;

import com.jk.bean.ProductCopy;
import com.jk.bean.Search;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface JianShowMapper {

    //根据 查询
    ProductCopy queryThird(Integer id);

    List<ProductCopy> aaa(Integer id);

    List<Search> search(HashMap<String, Object> hashMap);

    List getMarkByIdClass2(Integer id);

    Search getFiltrate(Search search);

    @Select("select id,ppmch from t_mall_trade_mark where id = #{ppId}")
    Search getTopPp(Integer ppId);
}
