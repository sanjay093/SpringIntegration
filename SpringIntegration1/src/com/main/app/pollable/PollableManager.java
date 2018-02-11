package com.main.app.pollable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
@ImportResource("classpath:si-pollable.xml")
public class PollableManager implements CommandLineRunner {
	
	@Autowired
	private MessageChannel pChannel;
	
	public static void main(String[] args) {
		SpringApplication.run(PollableManager.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		 Message<?> receive = ((QueueChannel)pChannel).receive();
		 System.out.println(receive.getPayload());
		
	}
}
