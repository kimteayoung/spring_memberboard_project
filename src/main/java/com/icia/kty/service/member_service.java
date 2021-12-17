package com.icia.kty.service;

import java.util.List;

import com.icia.kty.dto.member_dto;

public interface member_service {

	int save(member_dto member);// 회원가입처리 2

	String idDuplicate(String m_id);// 아이디 중복체크 2

	String login(member_dto member);// 로그인 출력 2

	List<member_dto> admin(); // 관리자 페이지 출력 2

	member_dto findById(long m_number); // 상세조회 2

	void delete(long m_number); // 회원 삭제 2

	void update(member_dto member); // 업데이트 2

	member_dto mypage(long m_number);

	
	
}
	