package com.turkcell.sitemap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SitemapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SitemapApplication.class, args);
	
		
	}

}
 