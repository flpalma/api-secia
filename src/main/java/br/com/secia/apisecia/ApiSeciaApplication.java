package br.com.secia.apisecia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiSeciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSeciaApplication.class, args);
	}

}
