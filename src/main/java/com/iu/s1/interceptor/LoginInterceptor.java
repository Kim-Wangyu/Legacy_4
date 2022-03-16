package com.iu.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberDTO;


public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
			MemberDTO memberDTO=(MemberDTO)request.getSession().getAttribute("member");
			
			boolean check=true;
		
			if(memberDTO==null) {
				check = false;
				//1. forward 형식-servlet 문법사용
//				request.setAttribute("message", "로그인이 필요합니다.");
//				request.setAttribute("path", "../member/login");
//				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
//				view.forward(request, response);
				
				
				//2.redirect
				response.sendRedirect("../member/login"); //알람 메세지 없이 로그인창으로
				
			}
		
		return check;
	}

}
