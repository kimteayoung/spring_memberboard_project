package com.icia.kty.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.kty.dto.comment_dto;

@Repository
public class comment_repository {

	@Autowired
	   private SqlSessionTemplate sql;

	public void save(comment_dto comment) {
		 sql.insert("Comment.save", comment);
		
	}

	public List<comment_dto> findAll(long b_number) {
		  return sql.selectList("Comment.findAll", b_number);
	}
}
