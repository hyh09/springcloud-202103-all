package com.yunhui;


import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;



public class TestRetry {

    static Retryer<Boolean> retryer;

    static {
        retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfException() // 抛出异常会进行重试
                .retryIfResult(Predicates.equalTo(false)) // 如果接口返回的结果不符合预期,也需要重试
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS)) // 重试策略, 此处设置的是重试间隔时间
                .withStopStrategy(StopStrategies.stopAfterAttempt(5)) // 重试次数
                .build();
        System.out.println("================================");
    }

    public boolean uploadFile(final String fileName) {
        try {
        System.out.println("============"+retryer);
            return retryer.call(new Callable<Boolean>() {
                int count = 0;
                @Override
                public Boolean call() throws Exception {
                    return  uploadPicture(fileName, count++);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    @Test
    public  void Tes001()
    {
        uploadFile("testFile");
    }


//    public static void main(String[] args) {
//        new Test().uploadFile("testFile");
//    }


    public   Boolean  uploadPicture(String fileName,int count)
    {
        switch (count)
        {
            case 1: return  false;
            case 2: return  true;
            default: return  null;
        }
    }

}
