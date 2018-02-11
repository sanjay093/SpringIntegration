package com.main.app.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@ImportResource("classpath:si-amqp.xml")
public class SIAMQPManager implements CommandLineRunner {

	@Autowired
	private MessageChannel tradeProducer;

	public static void main(String[] args) {
		SpringApplication.run(SIAMQPManager.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		String msg = "Sanjay";
		for(int i = 1; i < 10; i++) {
			Message<String> payload = MessageBuilder.withPayload(msg+"_"+i).build();
			Thread.sleep(2000);
			tradeProducer.send(payload);
		}

	}
}
