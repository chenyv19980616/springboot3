package com.atguigu.boot3features;

import com.atguigu.boot3features.bean.Cat;
import com.atguigu.boot3features.bean.Child;
import com.atguigu.boot3features.bean.Dog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
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
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder()
				.main(Boot306FeaturesApplication.class)
				.sources(Boot306FeaturesApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

		try {
			Cat cat = applicationContext.getBean(Cat.class);
			log.info("组件cat:{}", cat);
		} catch (BeansException e) {

		}

		try {
			Dog dog = applicationContext.getBean(Dog.class);
			log.info("组件dog:{}", dog);
		} catch (BeansException e) {

		}


		try {
			Child child = applicationContext.getBean(Child.class);
			log.info("组件child:{}", child);
		} catch (BeansException e) {

		}


	}

}
