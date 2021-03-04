package com.yunhui.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "yun.url8081")
@Component
@Data
public class Url8081Bean {

    private String host;


    private Requeset requeset;


}
