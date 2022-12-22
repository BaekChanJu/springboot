package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.BoardVO;

@Mapper
//mapper에 있는 namespace 주소랑 id, resultType를 해당 인터페이스랑 다 이름이 같도록 맞춰줘야 함
public interface BoardDAO {
	public List<BoardVO> getBoardList(BoardVO vo);
	
	public void insertBoard(BoardVO vo);

	public void updateBoard(BoardVO vo) ;

	public void deleteBoard(BoardVO vo);

	public BoardVO getBoard(BoardVO vo) ;


}

/*
 * 기본적인 구조라면,
 * 인터페이스를 구현한 클래스 BoardDAOImpl.java
 * 그 클래스 @Repository 지정
 * 
 * */
