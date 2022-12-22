package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.MemberVO;
import com.example.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	 @Autowired 
	  private MemberService memberService;
	
	 
	 //이건 내가지금 html 폴더들을 member아래 넣어놔서
	 //페이지 설정용
	 @RequestMapping("/{step}")
		public String viewPage(@PathVariable String step) {
			return "member/"+ step;
		}
		
	 
	 
	 //회원가입 입력값을 디비에 저장하는 컨트롤러 
	 //인설트멤버폼에 액션 값과 여기 매핑값과 동일해야함 @{saveMember}
	 @RequestMapping("/saveMember")
		public ModelAndView userInsert(MemberVO memberVO) {
		 	//System.out.println("[MemberController: ]"+memberVO);
		 
		 int result = memberService.userInsert(memberVO);
			String message = "가입에 실패하셨습니다";
			if(result == 1) {
				message = memberVO.getUserName()+ "님 가입을 축하드립니다";
			}
		 
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/member/joinSuccess");
			mv.addObject("message", message);
			return mv;
			
		}
	 
	 
	 //회원가입후 로그인 성공했을때 실패했을때
	 @RequestMapping(value="/login", method=RequestMethod.POST)
		public String login(MemberVO vo,  HttpSession session) {
			
			MemberVO result = memberService.idCheck_Login(vo);
			
			if(result != null ) {
				//로성공경우 세션에 저장 중요!!!!
				session.setAttribute("member",  vo.getUserId());
				return "/member/loginSuccess";
			}else {
				return "/member/loginForm";
			}
		}
	 
	 
	 //여기 js 파일연동 ajox인데 안됌 ㅠ
	 @RequestMapping(value="idCheck",produces="application/text;charset=utf-8")
		@ResponseBody
		public String checkId(MemberVO memberVO) {
			
			//System.out.println("idCheck.od 요청" + memberVO.getUserId());
			
			MemberVO result = memberService.idCheck_Login(memberVO);
			String message = "사용가능아이디입니다";
			if(result != null) message = "중복된 아이디가 있습니당";
			
			//System.out.println("message :" + message);
			return message;
		}
		

	 
	 

	
	 
	 
	 

}
