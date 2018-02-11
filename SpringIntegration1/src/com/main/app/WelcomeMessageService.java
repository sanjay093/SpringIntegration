package com.main.app;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class WelcomeMessageService {
	public Message<Map<String, String>> processMessage(Message<String> message) {
		String payload = message.getPayload();
		System.out.println("Received massage: "+payload);
		payload =  "Welcome Mr. "+payload;
		System.out.println("Sending meaage:"+payload);
		return MessageBuilder.withPayload(Collections.singletonMap("message", payload))
		.copyHeadersIfAbsent(message.getHeaders())
		.setHeader("http_status", HttpStatus.OK)
		.build();
		
		
	}
}
