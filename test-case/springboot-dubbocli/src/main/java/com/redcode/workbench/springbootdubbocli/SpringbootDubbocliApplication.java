package com.redcode.workbench.springbootdubbocli;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring/applicationContext-*.xml")
//@EnableAutoConfiguration
public class SpringbootDubbocliApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubbocliApplication.class, args);
	}
}
