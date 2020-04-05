package com.kafka.kafkademo;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkademoApplication.class, args);
	}
	

	@Bean
    public ApplicationRunner runner(Producer producer) {
        return (args) -> {
            for(int i = 1; i < 20; i++) {
                    producer.send(new SampleMessage(i, "A simple test message::"+i+"; Time::"+new Date()));
            }
        };
    }

}
