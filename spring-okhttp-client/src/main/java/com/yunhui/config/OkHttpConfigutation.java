package com.yunhui.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@Data
public class OkHttpConfigutation {

    @Value("${ok.http.connect-timeout}")
    private Integer connectTimeout;

}
