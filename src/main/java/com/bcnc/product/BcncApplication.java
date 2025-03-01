package com.bcnc.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.bcnc.producto"})
@SpringBootApplication
public class BcncApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcncApplication.class, args);
	}

}
