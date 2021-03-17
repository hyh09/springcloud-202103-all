package com.yunhui.feign01.conifg;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    /**
     * 日志级别
     */
    @Bean
    public Logger.Level  feignLoggerLevel()
    {
        return  Logger.Level.FULL;  //full:  输出完整的请求信息
           //none :不输出日志
          //basic:  只请求url和响应状态码的以及执行时间
          //headders  ： 将basic信息和请求头信息输出
    }
}
