package com.yunhui.config;

import com.yunhui.intercept.MyLoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfigration {

    @Bean("restTemplate")
    @LoadBalanced //开启负载功能 经过注册中心Eureka里面
    //@MyLoadBalanced
    public RestTemplate  getRestTemplate(){
         return  new RestTemplate();
    }

    @Bean("RestTemplateBasics")
    public  RestTemplate  getRestTemplate01()
    {
        return  new RestTemplate();
    }



}


