package com.jk.client;

import com.jk.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("producer")
public interface LoginClient {

    @RequestMapping("queryloginuser")
    User queryloginuser(User user);



}
