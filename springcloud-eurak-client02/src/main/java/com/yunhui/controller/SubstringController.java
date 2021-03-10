package com.yunhui.controller;


import com.yunhui.config.Url8081Bean;
import com.yunhui.eurak.entity.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/substiution")
public class SubstringController {


    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate  restTemplate;


    @Autowired
    @Qualifier("RestTemplateBasics")
    private  RestTemplate  restTemplateBasics;
    @Autowired
    private Url8081Bean url8081Bean;


    @GetMapping("/callHello")
    public  String  callHello()
    {
        String  result =   restTemplate.getForObject("http://fsh-house/house/hello",String.class);
        System.out.println("调用结果:"+result);
        return  result;
    }
    /**
     * 经过 eureka 注册中心调用
     */
    @GetMapping("/callHellobyEureka")
    public  String  callHelloByEureka()
    {
        return  "通过eureka注册的调用："+restTemplate.getForObject("http://fsh-house/house/hello",String.class);
    }

    /**
     * http://localhost:8091//house/data?name=
     * @param name
     * @return
     */
    @GetMapping("/customer/data")
    public HouseInfo getData(@RequestParam("name") String  name)
    {
       System.out.println("url8081Bean.getRequeset()+name"+url8081Bean);
        return   restTemplateBasics.getForObject(url8081Bean.getRequeset().getHousedata()+name,HouseInfo.class);
//        return  restTemplateBasics.getForObject();
    }

    @GetMapping("/customer/data01")
    public HouseInfo getData01(@RequestParam("name") String  name)
    {

        return   restTemplateBasics.getForObject("http://localhost:8091/house/data?name="+name,HouseInfo.class);
//        return  restTemplateBasics.getForObject();
    }
}
