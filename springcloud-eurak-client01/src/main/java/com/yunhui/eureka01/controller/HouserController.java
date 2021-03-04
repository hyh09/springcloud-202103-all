package com.yunhui.eureka01.controller;


import com.yunhui.eurak.entity.HouseInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouserController {

    @GetMapping("/hello")
    public  String  hello()
    {
         return  "hello";
    }


    @GetMapping("/data")
    public HouseInfo  getData(@RequestParam("name") String name)
    {
        return  new HouseInfo(1l,"上海","虹口","东体小区");
    }


    @GetMapping("data/{name}")
    public  String getData2(@PathVariable("name") String name)
    {
        System.out.println("入参的参数:"+name);
        return  name;
    }





}
