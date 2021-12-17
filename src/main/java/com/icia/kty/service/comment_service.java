package com.icia.kty.service;

import java.util.List;

import com.icia.kty.dto.comment_dto;

public interface comment_service {

	void save(comment_dto comment);

	List<comment_dto> findAll(long b_number);

}
