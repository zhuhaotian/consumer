package com.jk.service.impl;

import com.jk.bean.Title;
import com.jk.bean.User;
import com.jk.mapper.TitleMapper;
import com.jk.service.TitleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {
    @Resource
    TitleMapper mapper;

    @Override
    public List<Title> getTitle() {

        return mapper.getTitle();
    }

    /**
     * 登录成功 根据手机号 查询出用户的信息 保存到session
     * @param phone_no
     * @return
     */
    @Override
    public User getUserByPhone(String phone_no) {
        return mapper.getUserByPhone(phone_no);
    }

    @Override
    public User selectPhoneState(String phone_no) {
        return mapper.selectPhoneState(phone_no);
    }
}
