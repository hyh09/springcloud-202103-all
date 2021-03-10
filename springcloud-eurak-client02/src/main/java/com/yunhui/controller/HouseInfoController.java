package com.yunhui.controller;


import com.yunhui.eurak.entity.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/house")
public class HouseInfoController {

    @Autowired
    @Qualifier("RestTemplateBasics")
    private  RestTemplate  restTemplateBasics;


    @GetMapping("/save")
    public  String  add(){
        System.out.println("====?===============");

        HouseInfo  houseInfo = new HouseInfo();
        houseInfo.setCity("上海");
        houseInfo.setRegion("虹口");
        houseInfo.setName("xxx");
        System.out.println("打印的入参"+houseInfo);

        String   id  = restTemplateBasics.postForObject(
                "http://localhost:8091/house/save",
                houseInfo,String.class

        );
        System.out.println("====?"+id);
        return  id+"";

    }


}
