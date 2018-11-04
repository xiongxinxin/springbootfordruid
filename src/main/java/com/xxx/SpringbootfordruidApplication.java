package com.xxx;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringbootfordruidApplication implements CommandLineRunner{
	
	@Autowired
	private DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootfordruidApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("dataSource: " + dataSource);
	}
}
