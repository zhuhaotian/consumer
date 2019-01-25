package com.jk.mapper;

import com.jk.bean.Comment;

import java.util.List;

public interface SearchMapper {

    public List<Comment> comment(Integer id);

    public void rules(Comment comment);
}
