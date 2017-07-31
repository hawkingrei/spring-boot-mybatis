package com.hawkingrei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hawkingrei.mapper")
public class ReaderApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReaderApplication.class, args);
	}
}
