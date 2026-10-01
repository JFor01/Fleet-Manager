package com.example.fleet_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FleetManagerApplication {


	public static void main(String[] args) {
		SpringApplication.run(FleetManagerApplication.class, args);
	}

}