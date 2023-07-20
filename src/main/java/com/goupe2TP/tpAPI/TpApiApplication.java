package com.goupe2TP.tpAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class TpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpApiApplication.class, args);
	}

}
