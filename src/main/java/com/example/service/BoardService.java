package com.example.service;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardService {
	
	public List<BoardVO> getBoardList(BoardVO vo);
	
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	

}
