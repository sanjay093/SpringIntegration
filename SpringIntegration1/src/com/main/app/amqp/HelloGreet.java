package com.main.app.amqp;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class HelloGreet {
	public String sayHello(Message<String> message) {
		System.out.println("in service activator");
		String name = message.getPayload();
		name = "Hello Mr. "+name;
		System.out.println(name);
		return name;
	}
}
