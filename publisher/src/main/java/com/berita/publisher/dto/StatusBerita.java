package com.berita.publisher.dto;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class StatusBerita {
	private Berita berita;
	private String status;//terbaca, belum dibaca
	private String message;

}
