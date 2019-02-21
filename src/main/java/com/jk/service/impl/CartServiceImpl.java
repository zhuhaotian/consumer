package com.jk.service.impl;

import com.jk.bean.Video;
import com.jk.mapper.CartMapper;
import com.jk.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;


    @Override
    public Video video(Integer id) {
        Video video = cartMapper.video(id);
        return video;
    }
}
