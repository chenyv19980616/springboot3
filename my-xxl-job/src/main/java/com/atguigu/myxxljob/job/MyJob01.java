package com.atguigu.myxxljob.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @author : chenyv
 * @since : 2024-04-20 13:50
 */
@Component
public class MyJob01 {

    @XxlJob("XXL")
    public void myTest(){
        System.out.println("chenyu");
    }
}
