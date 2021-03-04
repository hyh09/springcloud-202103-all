package com.ribbon.web.controller;

//import com.google.common.collect.Lists;
//import com.netflix.loadbalancer.ILoadBalancer;
//import com.netflix.loadbalancer.LoadBalancerBuilder;
//import com.netflix.loadbalancer.Server;
//import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
//import com.netflix.loadbalancer.reactive.ServerOperation;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import rx.Observable;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.List;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;


//@RestController
public class ServiceListController {
    public static void main(String[] args) {
        getserverlist();
    }

//    /**
//     * 服务列表的测试
//     */
//    @RequestMapping("/getserverlist")
    public  static void  getserverlist(){
        //服务列表
        List<Server> serverList  =  Lists.newArrayList(
                new Server("localhost",8091),new Server("localhost",8093));
        //构造负载实例
        BaseLoadBalancer loadBalancer =  LoadBalancerBuilder.newBuilder()
                .buildFixedServerListLoadBalancer(serverList);
       for(int i=0;i<5;i++){
           String result = LoadBalancerCommand.<String>builder()
                   .withLoadBalancer(loadBalancer)
                   .build()
                   .submit(new ServerOperation<String>() {
                       @Override
                       public Observable<String> call(Server server) {
                           try{
                               String  addr = "http://"+server.getHost()+":"+server.getPort()+"/house/hello";
                               System.out.println("调用地址:"+addr);
                               URL  url = new URL(addr);
                               HttpURLConnection  connection = (HttpURLConnection) url.openConnection();
                               connection.setRequestMethod("GET");
                               connection.connect();
                               InputStream  in = connection.getInputStream();
                               byte[] data = new byte[in.available()];
                               in.read(data);
                               return Observable.just(new String(data));

                           }catch (Exception e)
                           {

                           }
                           return null;
                       }
                   }).toBlocking().first();

           System.out.println("调用结果:"+result);
       }


    }
}
