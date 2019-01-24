package com.jk.service.impl;

import com.jk.bean.ProductCopy;
import com.jk.bean.Search;
import com.jk.mapper.JianShowMapper;
import com.jk.service.JianShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class JianShowServiceImpl implements JianShowService {

    @Resource
    JianShowMapper jianShowMapper;

    @Override
    public ProductCopy queryThird(Integer id) {

        return jianShowMapper.queryThird(id);
    }

    @Override
    public List<ProductCopy> aaa(Integer id) {

        return jianShowMapper.aaa(id);
    }

    @Override
    public List<Search> search(Search search) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("search",search);
        return jianShowMapper.search(hashMap);
    }
}
