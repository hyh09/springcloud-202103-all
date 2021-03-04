package com.yunhui;


import com.yunhui.config.Url8081Bean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplication {

    @Autowired
    private Url8081Bean url8081Bean;

    @Test
    public   void Test001()
    {
        System.out.println("====>"+url8081Bean);
    }
}
