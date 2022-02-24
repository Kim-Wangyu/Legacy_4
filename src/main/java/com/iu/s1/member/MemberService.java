package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.bankbook.BankBookDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	//update
	public int update(MemberDTO memberDTO)throws Exception{
		return memberDAO.update(memberDTO);
	}
	
	public MemberDTO mypage(MemberDTO memberDTO)throws Exception{
		return memberDAO.mypage(memberDTO);
		
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return memberDAO.login(memberDTO);
	}
	
	public int join(MemberDTO memberDTO)throws Exception{
		return memberDAO.join(memberDTO);
	}
}
