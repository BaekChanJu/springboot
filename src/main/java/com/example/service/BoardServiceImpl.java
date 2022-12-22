package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo){
		List<BoardVO> list = boardDAO.getBoardList(vo);
		System.out.println("[BoardService] 리스트 갯수:" + list.size());
		return list;
	}
	
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
		System.out.println("게시글 입력완료");
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		System.out.println("게시글 수정완료");
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
		System.out.println("게시글 삭제완료");
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("게시글 조회완료");
		return boardDAO.getBoard(vo);
	}


}
