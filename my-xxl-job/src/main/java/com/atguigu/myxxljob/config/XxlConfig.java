package com.atguigu.myxxljob.config;

import com.xxl.job.core.executor.XxlJobExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenyv
 * @since : 2024-04-24 22:20
 */
@Slf4j
@Configuration
public class XxlConfig {

    @Value("${xxl-job.address}")
    private String address;

    @Value("${xxl-job.appName}")
    private String appName;

    @Value("${xxl-job.port}")
    private int port;

    @Value("${xxl-job.ip}")
    private String ip;

    @Bean
    public XxlJobExecutor xxlJobExecutor(){
        log.info(">>>>>>>>>>>>>>>  xxl-job 注入 ...   <<<<<<<<<<<");
        XxlJobExecutor executor = new XxlJobExecutor();
        executor.setAppname(appName);
        executor.setPort(port);
        executor.setAddress(address);
        executor.setIp(ip);
        return executor;
    }
}
