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


    /**
     *  Failed to read HTTP message: org.springframework.http.converter.HttpMessageNotReadableException:
     *  JSON parse error: Can not deserialize instance of java.lang.Long out of START_OBJECT token;
     *  nested exception is com.fasterxml.jackson.databind.JsonMappingException:
     *  Can not deserialize instance of java.lang.Long out of START_OBJECT token
     *  at [Source: java.io.PushbackInputStream@1fc2770c; line: 1, column: 1]
     * @param houseInfo
     * @return
     */
    @PostMapping("/save")
    public  String   addData(@RequestBody HouseInfo houseInfo)
    {
        System.out.println("打印服务方的日志:"+houseInfo.getName());
        return "100";
    }





}
