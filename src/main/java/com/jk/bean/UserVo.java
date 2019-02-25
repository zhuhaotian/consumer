package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: yjm
 * @Date: 2019/2/25 09:57
 * @Description:    qq登录accessToken对象
        */
@Data
public class UserVo implements Serializable {

    private String uname;

    private String upwd;


}
