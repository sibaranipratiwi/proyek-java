package com.berita.publisher.dto;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Berita {

	private String BeritaId;
	private String judul;
	private String type;
}
