package com.atguigu.boot3features;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Boot306FeaturesApplication {

	public static void main(String[] args) {
		// SpringApplication.run(Boot306FeaturesApplication.class, args);

		// SpringApplication springApplication = new SpringApplication(Boot306FeaturesApplication.class);

		// 自定义SpringApplication的底层设置
		// springApplication.setBannerMode(Banner.Mode.OFF);

		// 运行
		// springApplication.run(args);

		// 流式编程
		new SpringApplicationBuilder()
				.main(Boot306FeaturesApplication.class)
				.sources(Boot306FeaturesApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

	}

}
