package com.mio.cfdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CatCfdiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatCfdiApplication.class, args);
	}

}
