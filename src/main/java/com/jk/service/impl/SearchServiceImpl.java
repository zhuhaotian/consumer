package com.jk.service.impl;

import com.jk.bean.Comment;
import com.jk.mapper.SearchMapper;
import com.jk.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Resource
    private SearchMapper SearchMapper;

    public List<Comment> comment(Integer id){
         List<Comment> list = SearchMapper.comment(id);
        return list;
    }
    public void rules(Comment comment){
        SearchMapper.rules(comment);

    }
}
