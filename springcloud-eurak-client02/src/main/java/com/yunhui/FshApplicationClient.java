package com.yunhui;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient  /**  客户端 ，消费*/
@SpringBootApplication
public class FshApplicationClient {

    public  static  void main(String[] args)
    {
        SpringApplication.run(FshApplicationClient.class,args);
    }
}
