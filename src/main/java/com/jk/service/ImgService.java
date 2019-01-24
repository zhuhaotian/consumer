package com.jk.service;

import com.jk.bean.ImgBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("producer")
public interface ImgService {

    @RequestMapping("ImgCon")
    List<ImgBean> Imon(ImgBean imgBean);

}
