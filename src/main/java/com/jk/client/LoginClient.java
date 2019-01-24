package com.jk.client;

import com.jk.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="producer")
public interface LoginClient {

    @RequestMapping(value = "/queryloginuser" , method= RequestMethod.POST)
    User queryloginuser(User user);

}
