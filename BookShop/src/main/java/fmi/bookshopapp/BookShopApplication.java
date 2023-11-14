package fmi.bookshopapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fmi.bookshop.repository.CustomerRepository;

@SpringBootApplication
public class BookShopApplication {
	
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookShopApplication.class, args);
	}

}
