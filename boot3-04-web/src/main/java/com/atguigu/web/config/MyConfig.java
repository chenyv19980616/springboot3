package com.atguigu.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

/**
 * @author : chenyv
 * @since :  2024-02-26 10:24:26
 **/
@EnableWebMvc
@Configuration
public class MyConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override //配置静态资源
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/a/", "classpath:/b/")
                        .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
            }

            @Override //配置拦截器
            public void addInterceptors(InterceptorRegistry registry) {

            }

            // @Override //配置一个能把对象转为yaml的messageConverter
            // public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            //     converters.add(new MyYamlHttpMessageConverter());
            // }
        };
    }


    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //     // 保留原始配置
    //     WebMvcConfigurer.super.addResourceHandlers(registry);
    //
    //     registry.addResourceHandler("/static/**")
    //             .addResourceLocations("classpath:/a/","classpath:/b/")
    //             .setCacheControl(CacheControl.maxAge(1800, TimeUnit.SECONDS));
    // }

}
