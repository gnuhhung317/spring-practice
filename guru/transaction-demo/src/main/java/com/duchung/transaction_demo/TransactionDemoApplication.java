package com.duchung.transaction_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class TransactionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionDemoApplication.class, args);
	}

}
