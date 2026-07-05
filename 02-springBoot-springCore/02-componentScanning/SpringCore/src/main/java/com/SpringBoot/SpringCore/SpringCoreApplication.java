package com.SpringBoot.SpringCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		scanBasePackages = {"com.SpringBoot.SpringCore","com.SpringBoot.util"}
//)

@SpringBootApplication

public class SpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
	}

}
