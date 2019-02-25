package com.jk.utils;

import com.jk.bean.UserVo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yjm
 * @Date: 2019/2/25 10:15
 * @Description:
 */
public class LoginUserVo {

    private
    static  HashMap<String, UserVo> loginUserMap = new
            HashMap<String, UserVo>();

    private
    static  LoginUserVo loginUserVo;

    public
    static  LoginUserVo getVo(){

        if(loginUserVo == null){

            loginUserVo = new
                    LoginUserVo();

        }

        return
                loginUserVo;

    }

    public
    static  HashMap<String, UserVo> getLoginUserMap() {

        return
                loginUserMap;

    }

}
