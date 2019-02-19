package com.jk.service;

import com.jk.bean.Title;
import com.jk.bean.User;

import java.util.List;

public interface TitleService {
    List<Title> getTitle();

    User getUserByPhone(String phone_no);

    //查询手机号是否在 黑名单中
    User selectPhoneState(String phone_no);
}
