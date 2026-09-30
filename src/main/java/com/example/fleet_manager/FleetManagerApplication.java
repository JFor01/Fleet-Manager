package com.example.fleet_manager;

import com.example.fleet_manager.driver.Driver;
import com.example.fleet_manager.driver.DriverRepository;
import com.example.fleet_manager.driver.DriverService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FleetManagerApplication {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}



	public static void main(String[] args) {
		SpringApplication.run(FleetManagerApplication.class, args);
	}

}