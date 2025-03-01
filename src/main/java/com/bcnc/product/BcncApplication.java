package com.bcnc.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bcnc.product")
public class BcncApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcncApplication.class, args);
	}

}
