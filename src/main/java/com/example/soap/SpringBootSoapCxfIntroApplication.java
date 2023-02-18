package com.example.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.soap.service.HelloWorldWSImplService;

@SpringBootApplication
public class SpringBootSoapCxfIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapCxfIntroApplication.class, args);
		HelloWorldWSImplService helloWorldWSImplService = new HelloWorldWSImplService();;
		String createHello = helloWorldWSImplService.getHelloWorldWSImplPort().createHello("hi");
		System.out.println(createHello);
	}

}
