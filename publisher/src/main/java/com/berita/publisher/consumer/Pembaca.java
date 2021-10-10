package com.berita.publisher.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.berita.publisher.config.MessagingConfig;
import com.berita.publisher.dto.StatusBerita;

@Component
public class Pembaca {
	
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(StatusBerita statusBerita) {
		System.out.println("Berita diterima dari queue : " +statusBerita);
	}
}
