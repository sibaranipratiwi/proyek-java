package com.berita.publisher.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berita.publisher.config.MessagingConfig;
import com.berita.publisher.dto.Berita;
import com.berita.publisher.dto.StatusBerita;


@RestController
@RequestMapping("/berita")
public class PembuatBerita {
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/{penulisBerita}")
	public String bacaBerita(@RequestBody Berita berita,@PathVariable String penulisBerita) {
		berita.setBeritaId(UUID.randomUUID().toString());
		
		StatusBerita statusBerita = new StatusBerita(berita, "PROCESS", "Anda Telah membacanya"+penulisBerita);
		template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING, statusBerita);
		return "Berhasil";
	}
}
