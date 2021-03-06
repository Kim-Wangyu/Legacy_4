package com.iu.s1.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.member.MemberDTO;

@Component
public class WriterCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		System.out.println("WriterCheck Interceptor PostHandler");
		
		String method = request.getMethod();
		System.out.println("Method : "+method);  //Get메서드인지 POST메서드인지 확인, GET으로 해야함, 들어올때, POST는 나갈때임
		
		if(method.equals("POST")) {
			return;
		}
	
		//login 정보
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		//writer 정보
		Map<String, Object> map = modelAndView.getModel();
		
		BoardDTO boardDTO = (BoardDTO)map.get("dto");
		
		System.out.println(memberDTO.getId());
		System.out.println(boardDTO.getWriter());
		
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			//Spring문법
			//1.forword
			
			modelAndView.addObject("message","접근 권한이 없습니다.");
			modelAndView.addObject("path","./list");
			modelAndView.setViewName("common/result");
			
			//2.redirect
		}
		
	}

}
