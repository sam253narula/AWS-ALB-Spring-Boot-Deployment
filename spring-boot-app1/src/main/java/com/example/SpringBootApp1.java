package com.example;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootApp1 {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp1.class, args);
	}
	
	@GetMapping("/demo")
	public String demo() throws UnknownHostException {
		String ip = Inet4Address.getLocalHost().getHostAddress();
		return "This is simple demo project which runs on machine with IP Address: "+ ip;
	}

}
