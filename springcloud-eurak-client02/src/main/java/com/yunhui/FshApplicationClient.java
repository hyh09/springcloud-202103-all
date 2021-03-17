package com.yunhui;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableDiscoveryClient  /**  客户端 ，消费*/
@SpringBootApplication(scanBasePackages = "com.yunhui")
@EnableFeignClients(basePackages = "com.yunhui.feign01.svc")
public class FshApplicationClient {

    public  static  void main(String[] args)
    {
        SpringApplication.run(FshApplicationClient.class,args);
    }
}
