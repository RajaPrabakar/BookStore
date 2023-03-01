package com.example.student.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

//	@Override
//	public void run(String... args) throws Exception {
//		String sql;
//		sql ="INSERT INTO student(id,name) VALUES (9,'PRABAKAR')";
//		int rows = jdbcTemplate.update(sql);
//		if(rows>0){
//			System.out.println("A new row is Inserted");
//		}
//	}
}
