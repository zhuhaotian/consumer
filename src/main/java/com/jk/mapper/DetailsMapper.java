package com.jk.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DetailsMapper {
    List querydetails(@Param("shpid") Integer shpid);

    List queryimgdetails(@Param("shpid") Integer shpid);
}
