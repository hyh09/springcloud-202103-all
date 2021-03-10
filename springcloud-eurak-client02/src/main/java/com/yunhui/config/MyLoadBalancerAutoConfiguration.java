package com.yunhui.config;


import com.yunhui.intercept.MyLoadBalanced;
import com.yunhui.intercept.MyLoadBalancerInterceptor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class MyLoadBalancerAutoConfiguration {

    @Autowired(required = false)
    @MyLoadBalanced
    private List<RestTemplate> restTemplateList = Collections.emptyList();

    @Bean
    public MyLoadBalancerInterceptor  myLoadBalancerInterceptor()
    {
        return  new MyLoadBalancerInterceptor();
    }

    @Bean
    public SmartInitializingSingleton  smartInitializingSingleton()
    {
        return  new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                for(RestTemplate  restTemplate: restTemplateList)
                {
                    List<ClientHttpRequestInterceptor> list = new ArrayList<ClientHttpRequestInterceptor>(restTemplate.getInterceptors());
                    list.add(myLoadBalancerInterceptor());
                    restTemplate.setInterceptors(list);
                }
            }
        };
    }
}
