package com.yunhui.feign01.svc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "fsh-house",path = "/house")
public interface HouseRemoteSvc {

    @GetMapping("/hello")
    String hello();
}
