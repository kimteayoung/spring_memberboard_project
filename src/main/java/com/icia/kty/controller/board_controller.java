package com.icia.kty.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.kty.dto.board_dto;
import com.icia.kty.dto.comment_dto;
import com.icia.kty.dto.page_dto;
import com.icia.kty.service.board_service;
import com.icia.kty.service.comment_service;



@Controller
@RequestMapping(value="/board/*")
public class board_controller {

	@Autowired
	private board_service bs;
	
	@Autowired 
	private comment_service cs;
	
	// 글쓰기 페이지 출력
		@RequestMapping(value="save", method=RequestMethod.GET)
		public String saveForm() {
			// views/board 폴더에 있는 save.jsp를 출력
			return "/board/save";
		}
		// 글쓴거 DB에 저장하고 글목록으로 
		@RequestMapping(value="save", method=RequestMethod.POST)
		public String save(@ModelAttribute board_dto board) {
			bs.save(board);
			return "redirect:/board/paging";
		}
		// 글쓴거 목록 처리
		@RequestMapping(value="findAll", method=RequestMethod.GET)
		public String findAll(Model model) {
			List<board_dto>boardList = bs.findAll();
			model.addAttribute("boardList",boardList);
			return "board/findAll";
		}
		// 상세조회
		@RequestMapping(value="detail", method=RequestMethod.GET)
		public String findById(@RequestParam("b_number") long b_number, Model model,@RequestParam(value="page", required=false, defaultValue="1")int page) {
			board_dto board = bs.findById(b_number);
			List<comment_dto>commentList = cs.findAll(b_number);
			model.addAttribute("commentList",commentList);
			model.addAttribute("board",board);
			model.addAttribute("page",page); // detail.jsp로 갈 때 page 값을 가지고 감.
			return "board/detail";
		}
		// 수정 화면요청
		@RequestMapping(value="update", method=RequestMethod.GET)
		public String updateForm(@RequestParam("b_number")long b_number,Model model,@RequestParam(value="page", required=false, defaultValue="1")int page) {
			board_dto board = bs.findById(b_number);
			model.addAttribute("board",board);
			model.addAttribute("page",page);
			return "board/update";
		}
		
		// 수정처리
		@RequestMapping(value="update", method=RequestMethod.POST)
		public String update(@ModelAttribute board_dto board,@RequestParam(value="page", required=false, defaultValue="1")int page) {
			bs.update(board);
			return "redirect:/board/detail?b_number="+ board.getB_number() + "&page=" +page;
		}
	
		// 삭제 처리
		@RequestMapping(value="delete", method=RequestMethod.GET)
		public String delete(@RequestParam("b_number")long b_number) {
			bs.delete(b_number);
			return "redirect:/board/findAll";
		}
		// 페이징 
		@RequestMapping(value="paging", method=RequestMethod.GET)
		// value: 파라미터리음, required: 필수여부 , defaultValue: 기본값(page 요청값이 없으면 1로 세팅)
		public String paging(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
			List<board_dto> boardList = bs.pagingList(page);
			page_dto paging = bs.paging(page);
			model.addAttribute("boardList", boardList);
			model.addAttribute("paging", paging);
			return "board/findAll";
		}
		@RequestMapping(value="search", method=RequestMethod.GET)
		public String search(@RequestParam("searchtype") String searchtype, @RequestParam("keyword") String keyword, Model model) {
			List<board_dto>boardList = bs.search(searchtype,keyword );
			model.addAttribute("boardList",boardList);
			return "board/findAll";
		}
}
