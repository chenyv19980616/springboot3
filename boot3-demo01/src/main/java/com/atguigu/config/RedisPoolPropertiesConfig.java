package com.atguigu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : chenyv
 * @description : redis配置类
 * @since : 2023-12-08 00:24
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.data.redis")
public class RedisPoolPropertiesConfig {

    private String password;

    private String host;

    private Integer port;
}
