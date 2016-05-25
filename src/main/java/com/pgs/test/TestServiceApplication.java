package com.pgs.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@SpringBootApplication
@RestController
@RefreshScope
public class TestServiceApplication {

	@Value("${custommessage:Default message!!!}")
	String message;

	@RequestMapping("/project")
	String projectName() {
		return this.message;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestServiceApplication.class, args);
	}
}
