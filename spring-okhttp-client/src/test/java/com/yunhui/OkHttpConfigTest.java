package com.yunhui;


import com.yunhui.config.OkHttpConfigutation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringOkhttpClientApplication.class)
public class OkHttpConfigTest {

    @Autowired
    private OkHttpConfigutation okHttpConfigutation;

    @Test
    public  void Test1()
    {
        System.out.println("=================>"+okHttpConfigutation);

        System.out.println("=================>"+okHttpConfigutation.getConnectTimeout());
    }
}
