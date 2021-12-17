package com.icia.kty.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class board_dto {
	
	private long b_number;
	private String b_writer;
	private String b_title;
	private String b_contentsl;
	private int b_hits;
	private Timestamp b_date;

}
