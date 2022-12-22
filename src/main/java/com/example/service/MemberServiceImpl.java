package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	
	@Autowired
	private MemberDAO memberdao;
	
	
	  public int userInsert(MemberVO vo )
	   {
		  int result = memberdao.userInsert(vo);
		  System.out.println(result);
		  return result;
	   }
	  
	  
	  public MemberVO idCheck_Login( MemberVO vo)
	  {
		  return memberdao.idCheck_Login(vo);
	  }
	  
	  
	   

}
