package com.icia.kty.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.kty.dto.member_dto;
import com.icia.kty.repository.member_repository;


@Service
public class member_serviceimpl implements member_service {

	@Autowired
	private member_repository mr;
	
	@Autowired
	private HttpSession session;

	// 회원가입처리 3
	@Override
	public int save(member_dto member) {
		return mr.save(member);
	}

	// 아이디 중복체크 3
	@Override
	public String  idDuplicate(String m_id) {
		String result = mr.idDuplicate(m_id);
		if(result == null)
			return "ok";
		else
			return "no";
	}

	// 로그인 출력 3
	@Override
	public String login(member_dto member) {
		member_dto loginMember = mr.login(member);
		if(loginMember != null) {
			// 로그인 성공(로그인 정보를 세션에 저장)
			session.setAttribute("loginId",member.getM_id());
			session.setAttribute("loginNumber",loginMember.getM_number());
			return "redirect:/board/paging";
		}else {
			// 로그인 실패
			return "/member/login";
		}
	}
	// 관리자 페이지 출력 3
	@Override
	public List<member_dto> admin() {
		List<member_dto> memberList = mr.admin();
		return memberList;
	}

	
	// 상세조회 3
	@Override
	public member_dto findById(long m_number) {
		member_dto member = mr.findById(m_number);
		return member;
	}
	// 회원 삭제 3
	public void delete(long m_number) {
		mr.delete(m_number);
	}
	// 업데이트 3
	public void update(member_dto member) {
		mr.update(member);
		
	}

	@Override
	public member_dto mypage(long m_number) {
		member_dto m = mr.mypage(m_number);
		
		return m;
	}



}
