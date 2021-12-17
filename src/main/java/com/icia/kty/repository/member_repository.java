package com.icia.kty.repository;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.kty.dto.member_dto;


@Repository
public class member_repository {
	
	@Autowired
	private SqlSessionTemplate sql;

	// 회원가입처리 4
	public int save(member_dto member) {
		return sql.insert("Member.save",member);
	}

	// 아이디 중복체크 4
	public String idDuplicate(String  m_id) {
		return sql.selectOne("Member.idDuplicate", m_id);
	}
	// 로그인 출력 4
	public member_dto login(member_dto member) {
		return sql.selectOne("Member.login", member);
	}
	// 관리자 페이지 출력 4
	public List<member_dto> admin() {
		return sql.selectList("Member.admin");
	}
	// 상세조회 4
	public member_dto findById(long m_number) {
		return sql.selectOne("Member.findById", m_number);
	}
	// 회원 삭제 4
	public void delete(long m_number) {
		sql.delete("Member.delete", m_number);
		
	}
	// 업데이트 4
	public void update(member_dto member) {
		sql.update("Member.update",member);
		
	}

	public member_dto mypage(long m_number) {
		return sql.selectOne("Member.mypage", m_number);
	}
	
}
