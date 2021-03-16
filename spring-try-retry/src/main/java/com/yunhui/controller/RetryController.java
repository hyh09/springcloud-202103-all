package com.yunhui.controller;


import com.yunhui.svcimpl.RetryServiceSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retry")
public class RetryController {


    @Autowired
    private RetryServiceSvc retryService;


    @RequestMapping("/test")
    public  String retry(@RequestParam("num") final  int  num) throws Exception {
        return  retryService.doRetry(num);
    }


}
