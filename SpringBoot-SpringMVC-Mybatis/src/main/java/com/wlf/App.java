package com.wlf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.wlf.mapper")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}
