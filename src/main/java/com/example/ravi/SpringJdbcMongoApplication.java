package com.example.ravi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcMongoApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcMongoApplication.class, args);
		System.out.println("Hello World");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Customer c1 = new Customer("1","Novartis","Pharma");
		Customer c2 = new Customer("2","Dr. Reddys","Labs");
		Customer c3 = new Customer("3","MyLan","Industries");
		Customer c4 = new Customer("4","Murk","Laboratories");
		
		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);
		customerRepository.save(c4);
		System.out.println("**************************");
		List<Customer> customers = customerRepository.findAll();
		for(Customer c: customers) {
			System.out.println(c.toString());
		}
	}

}
