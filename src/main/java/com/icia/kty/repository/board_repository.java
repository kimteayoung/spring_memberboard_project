package com.icia.kty.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.kty.dto.board_dto;

@Repository
public class board_repository {
	
	@Autowired
	private SqlSessionTemplate sql;

	// 글쓴거 DB에 저장하고 글목록으로
	public void save(board_dto board) {
		sql.insert("Board.save",board);	
	}

	// 글쓴거 목록 처리
	public List<board_dto> findAll() {
		return sql.selectList("Board.findAll");
	}

	// 조회수 늘려주는거
	public void hits(long b_number) {
		sql.update("Board.hits",b_number);	
	}

	// 상세조회
	public board_dto findById(long b_number) {
		return sql.selectOne("Board.findById",b_number);
	}
	// 수정처리
	public void update(board_dto board) {
		sql.update("Board.update",board);
		
	}

	// 삭제 처리
	public void delete(long b_number) {
		sql.delete("Board.delete",b_number);
		
	}
	// 페이징 처리
	public int boardCount() {
		return sql.selectOne("Board.count");
	}

	public List<board_dto> pagingList1(Map<String, Integer> pagingParam) {
		return sql.selectList("Board.pagingList1", pagingParam);
	}

	public List<board_dto> search(Map<String, String> searchParam) {
		return sql.selectList("Board.search", searchParam);
	}

}
