package com.kafka.kafkademo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessageController {
	private int id = 0;

	@Autowired
	private Producer producer;
	
	@GetMapping("/send")
	public String sendMessage() {
		this.producer.send(new SampleMessage(id++, "Message::"+this.id+" Time::"+new Date()));
		return "\"status\":\"OK\"";
	}
}
