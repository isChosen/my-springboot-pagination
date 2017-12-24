package com.liangchaoshun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liangchaoshun.dao")
public class LiangchaoshunApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiangchaoshunApplication.class, args);
	}
}
