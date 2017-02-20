package com.gyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 启动定时任务配置
@EnableScheduling
// 启动异步调用配置
@EnableAsync
public class StudySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudySpringBootApplication.class, args);
	}
}
