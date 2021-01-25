package com.mio.cfdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class CatCfdiApplication {

	private static final Logger logger = LoggerFactory.getLogger(CatCfdiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CatCfdiApplication.class, args);
	}

	@Bean
    public Catalogos catalogosDefault(@Value("${default.hojas}") String[] hojas) {
        return () -> hojas;
    }
}
