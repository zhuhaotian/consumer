package com.jk.client;

import com.jk.bean.Mallsku;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("es")
public interface esClient {
    @RequestMapping("/es/esselect")
    public List esarr(Mallsku Mallsku);
}
