package com.jk.service.impl;

import com.jk.bean.ProductCopy;
import com.jk.mapper.JianShowMapper;
import com.jk.service.JianShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JianShowServiceImpl implements JianShowService {

    @Autowired
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
    public List<ProductCopy> queryPrice(Integer id) {

        return jianShowMapper.queryPrice(id);
    }
}
