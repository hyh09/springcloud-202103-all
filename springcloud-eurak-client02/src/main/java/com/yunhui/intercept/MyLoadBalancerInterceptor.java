package com.yunhui.intercept;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.net.URI;

public class MyLoadBalancerInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept
            (HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution)
            throws IOException
    {
        final URI originalUri = httpRequest.getURI();
        String  serviceName = originalUri.getHost();
        System.out.println("进入自定义的请求拦截的中:"+serviceName);
        return  clientHttpRequestExecution.execute(httpRequest,bytes);

    }
}
