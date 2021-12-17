package com.icia.kty.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.kty.dto.board_dto;
import com.icia.kty.dto.page_dto;
import com.icia.kty.repository.board_repository;

@Service
public class board_serviceimpl implements board_service {
	
	@Autowired
	private board_repository br;

	 // 글쓴거 DB에 저장하고 글목록으로
	@Override
	public void save(board_dto board) {
		br.save(board);
	}
	// 글쓴거 목록 처리
	@Override
	public List<board_dto> findAll() {
		return br.findAll();
	}
	// 상세조회
	@Override
	public board_dto findById(long b_number) {
		br.hits(b_number);
		return br.findById(b_number);
	}
	// 수정처리
	@Override
	public void update(board_dto board) {
		br.update(board);		
	}
	// 삭제 처리
	@Override
	public void delete(long b_number) {
		br.delete(b_number);		
	}
	
	// 페이징 처리
	private static final int PAGE_LIMIT = 5; // 한페이지에 보여질 글 개수 , 5개면 글 다섯개
	private static final int BLOCK_LIMIT = 3; // 한화면에 보여질 페이지 개수 ,밑에 보여지는 글 숫자 
		// 필요한 총 페이지 갯수 계산,
		// 현재 사용자가 요청한 페이지가 2페이지라면 화면에는 1,2,3,을 보여주고
		// 요청 페이지가 6페이지라면 화면에 4,5,6을 보여준다.
		// 요청 페이지가 7페이지라면 화면에 7을 보여준다.
	@Override
	public page_dto paging(int page) {
		int boardCount = br.boardCount(); // 전체 글 갯수 조회,
		int maxPage = (int)(Math.ceil((double)boardCount / PAGE_LIMIT)); // 전페 페이지 계산 [ceil(ceil((double)boardCount / PAGE_LIMIT))은 반올림 해주는 메서드]
		// 2페이지를 요청했으면 1페이지, 4페이지를 요청했으면 4페이지, 8페이지를 요청했으면 7페이지의 값을 갖도록 계산
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1; // 3, 6, 9 페이지
		if(endPage > maxPage)
			endPage = maxPage; 
		page_dto paging = new page_dto();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		System.out.println("paging.toString(): "+ paging.toString());
		
		return paging;
	}
	@Override
	public List<board_dto> pagingList(int page) {
				// 1페이지 limit 0,3 2페이지 limit 3,3
				int pagingStart = (page-1) * PAGE_LIMIT;
				Map<String, Integer> pagingParam = new HashMap<String, Integer>();
				pagingParam.put("start", pagingStart);
				pagingParam.put("limit", PAGE_LIMIT);
				// List<BoardDTO> pagingList = br.pagingList(pagingStart);
				List<board_dto> pagingList = br.pagingList1(pagingParam);
				for(board_dto b: pagingList) {
					System.out.println(b.toString());
				}
				return pagingList;
	}
	@Override
	public List<board_dto> search(String searchtype, String keyword) {
		Map<String,String> searchParam = new HashMap<String, String>();
		searchParam.put("type", searchtype);
		searchParam.put("word", keyword);
		List<board_dto> boardList = br.search(searchParam);
		return boardList;
	}
	@Override
	public void hits(long b_number) {
		br.hits(b_number);
		
	}

}
