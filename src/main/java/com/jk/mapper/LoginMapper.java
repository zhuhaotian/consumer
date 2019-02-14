package com.jk.mapper;

import com.jk.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    public void registertwo(User user);
}
