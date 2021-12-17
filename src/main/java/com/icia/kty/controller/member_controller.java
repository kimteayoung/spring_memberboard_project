package com.icia.kty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.kty.dto.member_dto;
import com.icia.kty.service.member_service;


@Controller
@RequestMapping(value="/member/*")
public class member_controller {
	
	// 서버 8084로 만듬
	
	@Autowired
	private member_service ms;

	// 회원가입 1
	@RequestMapping(value = "save", method = RequestMethod.GET)
	public String saveForm() {	
		return "/member/save";
	}
	// 회원가입처리 1
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute member_dto member) {	
		System.out.println("member_controller.save():" + member);
		int result = ms.save(member);
		if(result > 0)
			return "index";
		else
			return "/member/save";
	}
	// 아이디 중복체크 1
		@RequestMapping(value="idDuplicate", method=RequestMethod.POST)
		public @ResponseBody String  idDuplicate(@RequestParam("m_id") String  m_id) {
			System.out.println("member_controller.idDuplicate(): "+ m_id);
			String  result = ms.idDuplicate(m_id);
			return result; // "ok" or "no"
		}
	// 로그인 페이지 1
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginForm() {	
		return "/member/login";
	}
	// 로그인 출력 1
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute member_dto member) {
		String resultPage = ms.login(member);	
		return resultPage;		
	}
	// 로그아웃 처리 1
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public  String logout(HttpSession session) {
		// 세숀에 저장된 데이터를 지움.
		session.invalidate();
		return "index";
	}
	
	// 관리자 페이지 출력 1
	@RequestMapping(value="admin", method=RequestMethod.GET)
	public String admin(Model model) {
		List<member_dto> memberList = ms.admin();
		
		model.addAttribute("memberList", memberList);
		
		return "/member/admin"; 
	}
	// 상세조회 1
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String findById(@RequestParam("m_number") long m_number, Model model) {
		member_dto member = ms.findById(m_number);
		model.addAttribute("member",member);
		return "/member/detail";
	}
	// 회원 삭제 1
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam("m_number") long m_number) {
		System.out.println("delete: "+ m_number);
		
		ms.delete(m_number);
		
		return "redirect:/member/admin";
	}
	// 업데이트 1
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String updateForm(@RequestParam("m_number") long m_number, Model model) {
		System.out.println("update: "+ m_number);	
		member_dto member = ms.mypage(m_number);
		model.addAttribute("member",member);
		return "/member/update";
	}
	@RequestMapping(value="mypage", method=RequestMethod.GET)
	public String mypage(@RequestParam("m_number") long m_number, Model model) {
		member_dto m = ms.mypage(m_number);
		model.addAttribute("mypage",m);
		return "/member/mypage";
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute member_dto m, Model model){
		ms.update(m);
		return "redirect:/member/mypage?m_number="+m.getM_number();
	}

}











