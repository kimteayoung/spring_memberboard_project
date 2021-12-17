package com.icia.kty.service;

import java.util.List;

import com.icia.kty.dto.board_dto;
import com.icia.kty.dto.page_dto;

public interface board_service {

	void save(board_dto board); // 글쓴거 DB에 저장하고 글목록으로 

	List<board_dto> findAll(); // 글쓴거 목록 처리

	void update(board_dto board); // 수정처리

	void delete(long b_number);// 삭제 처리

	List<board_dto> pagingList(int page);

	page_dto paging(int page);

	List<board_dto> search(String searchtype, String keyword);

	void hits(long b_number);

	board_dto findById(long b_number);

}
