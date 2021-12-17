package com.icia.kty.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class comment_dto {
	private long c_number;
	private long b_number;
	private String c_writer;
	private String c_contentsl;
	private Timestamp c_date;

}
