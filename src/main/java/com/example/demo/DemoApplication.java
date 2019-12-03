package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		list.forEach(System.out::println);
		List<String> synchronizedList = Collections.synchronizedList(list);
	}

}
