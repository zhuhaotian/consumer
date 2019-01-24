package com.jk.service.impl;

import com.jk.bean.Info;
import com.jk.bean.User;
import com.jk.mapper.DetailsMapper;
import com.jk.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    private DetailsMapper detailsMapper;

    @Override
    public List querydetails(Integer shpid) {

        return detailsMapper.querydetails(shpid);
    }
}
