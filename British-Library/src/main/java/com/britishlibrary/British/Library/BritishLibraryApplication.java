package com.britishlibrary.British.Library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class BritishLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BritishLibraryApplication.class, args);
	}

}
