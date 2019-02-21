package com.jk.mapper;

import com.jk.bean.Title;
import com.jk.bean.User;

import java.util.List;

public interface TitleMapper {
    List<Title> getTitle();

    User getUserByPhone(String phone_no);

    User selectPhoneState(String phone_no);
}
