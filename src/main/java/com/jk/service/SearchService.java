package com.jk.service;

import com.jk.bean.Comment;

import java.util.List;

public interface SearchService {


    public List<Comment> comment(Integer id);

    public void rules(Comment comment);

}
