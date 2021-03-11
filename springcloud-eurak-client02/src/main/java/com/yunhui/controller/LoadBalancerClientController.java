package com.yunhui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadBalancerClientController {

    @Autowired
    private LoadBalancerClient   loadBalancerClient;

    @RequestMapping("/choose")
    public Object  chooseUrl()
    {
        return loadBalancerClient.choose(" fsh-house");
    }


}
