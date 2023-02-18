package com.example.soap.service;

import org.springframework.stereotype.Component;

import com.example.soap.service.HelloWorldWS;

@Component
public class HelloWorldWSImpl implements HelloWorldWS {

	@Override
	public String createMessage(String name) {
		System.out.println("create message endpoint");
		return "Hello "+name;
	}

	@Override
	public String createHello(String name) {
		return "Hello dear " + name;
	}

}
