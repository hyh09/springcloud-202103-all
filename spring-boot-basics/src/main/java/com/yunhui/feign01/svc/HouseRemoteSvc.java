package com.yunhui.feign01.svc;

import com.yunhui.feign01.conifg.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * FeignConfiguration  配置fegin配置
 */
@FeignClient(value = "fsh-house",path = "/house" ,configuration = FeignConfiguration.class)
public interface HouseRemoteSvc {

    @GetMapping("/hello")
    String hello();
}
