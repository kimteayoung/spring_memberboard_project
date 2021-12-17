package com.icia.kty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.kty.dto.comment_dto;
import com.icia.kty.repository.comment_repository;

@Service
public class comment_serviceimpl implements comment_service {

	@Autowired
	private comment_repository cr;

	@Override
	public void save(comment_dto comment) {
		 cr.save(comment);
		
	}

	@Override
	public List<comment_dto> findAll(long b_number) {
		 return cr.findAll(b_number);
	}
}
