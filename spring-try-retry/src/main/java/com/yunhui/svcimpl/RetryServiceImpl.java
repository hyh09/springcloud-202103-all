package com.yunhui.svcimpl;


import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


/*
@EnableRetry：此注解用于开启重试框架，可以修饰在SpringBoot启动类上面，也可以修饰在需要重试的类上
   proxyTargetClass：Boolean类型，用于指明代理方式【true：cglib代理，false：jdk动态代理】默认使用jdk动态代理
@Retryable
   value：Class[]类型，用于指定需要重试的异常类型，
   include：Class[]类型，作用于value类似，区别尚未分析
   exclude：Class[]类型，指定不需要重试的异常类型
   maxAttemps：int类型，指定最多重试次数，默认3
   backoff：Backoff类型，指明补偿机制
   @BackOff
      delay:指定延迟后重试，默认为1000L,即1s后开始重试 ;
      multiplier:指定延迟的倍数
@Recover
   当重试次数耗尽依然出现异常时，执行此异常对应的@Recover方法。
   异常类型需要与Recover方法参数类型保持一致，
   recover方法返回值需要与重试方法返回值保证一致
 */
@Service
public class RetryServiceImpl implements RetryServiceSvc{


    /**
     *
     添加重试注解,当有异常时触发重试机制，
     设置重试4次,默认是3.延时2000ms再次执行,每次延时是上次延时的1.5倍.当返回结果不符合要求时,主动报错触发重试.
     */
    @Retryable(value = Exception.class, maxAttempts = 4, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    @Override
    public String doRetry(int num) throws Exception {
        System.out.println("开始执行"+ LocalDateTime.now());


        switch (num){
            case 6:
                throw  new  Exception("执行的时候异常了");

            case 7:
                int  a = 7/0;
                return  "============";
             default:
                return  "+++++++++++++++++";

        }


    }

    @Recover
    public String recover (Exception e) {
        return "num必须大于0";
    }
}
