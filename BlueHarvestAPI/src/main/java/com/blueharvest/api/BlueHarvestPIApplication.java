package com.blueharvest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.blueharvest")
public class BlueHarvestPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueHarvestPIApplication.class, args);
	}


}
