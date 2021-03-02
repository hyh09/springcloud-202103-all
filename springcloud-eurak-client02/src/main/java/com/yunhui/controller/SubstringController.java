package com.yunhui.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/substiution")
public class SubstringController {


    @Autowired
    private RestTemplate  restTemplate;


//    @GetMapping("/callHello")
//    public  String  callHello()
//    {
//        return  restTemplate.getForObject("http://localhost:8091/house/hello",String.class);
//    }
    /**
     * 经过 eureka 注册中心调用
     */
    @GetMapping("/callHellobyEureka")
    public  String  callHelloByEureka()
    {
        return  "通过eureka注册的调用："+restTemplate.getForObject("http://fsh-house/house/hello",String.class);
    }
}
