package com.atguigu.boot3features;

import com.atguigu.boot3features.service.impl.TestServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class Boot306FeaturesApplicationTests {

	@Autowired
	TestServiceImpl testService;

	@Test
	void contextLoads() {
		System.err.println(testService.test01());
		System.out.println(testService.sum(1, 1));
	}

	@ParameterizedTest
	@MethodSource("method")
	@DisplayName("参数化测试")
	void test01(String string) {
		System.out.println(string);
		Assertions.assertTrue(StringUtils.isNotBlank(string));
	}

	 static Stream<String> method() {
		 return Stream.of("apple", "banana");
	 }

}
