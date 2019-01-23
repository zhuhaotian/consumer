package com.jk.service.impl;

import com.jk.bean.productCopy;
import com.jk.mapper.JianShowMapper;
import com.jk.service.JianShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JianShowServiceImpl implements JianShowService {

    @Resource
    JianShowMapper jianShowMapper;

    @Override
    public List<productCopy> queryThird(Integer id) {

        return jianShowMapper.queryThird(id);
    }
}
