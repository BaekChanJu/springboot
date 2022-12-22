package com.example.service;

import com.example.domain.MemberVO;

public interface MemberService {
	public int userInsert(MemberVO vo );
	
	
	public MemberVO idCheck_Login( MemberVO vo);

}
