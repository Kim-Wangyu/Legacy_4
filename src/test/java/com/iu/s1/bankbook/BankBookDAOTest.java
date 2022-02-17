package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;

public class BankBookDAOTest extends MyJunitTest {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	
	@Test
	public void check() {
		assertNotNull(bankBookDAO);
	}
	
	//Detail
	@Test
	public void detail()throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
	
		bankBookDTO= bankBookDAO.detail(5L);
		assertNotNull(bankBookDTO);
	}
	
	
	//list
	@Test
	public void list() throws Exception{
		List<BankBookDTO> ar= bankBookDAO.list();
		
		assertNotEquals(0, ar.size());  
	}
	
	//Insert
	//@Test
	public void addTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("t2");  			//물음표,# 들어가는것만 입력, 넘버는 SEQ로 들어가니까 안함
		bankBookDTO.setBookContents("c2");
		bankBookDTO.setBookRate(3.12);
		bankBookDTO.setBookSale(1);
		
		int result = bankBookDAO.add(bankBookDTO);
		
		assertEquals(1, result);  //1이 오길 희망함, 예상함 (왼쪽은 희망값, 오른쪽은 실제 결과 값)
	}
	
	//delete
	@Test
	public void delete() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(4L);
		int result = bankBookDAO.delete(bankBookDTO);
		assertEquals(1, result);
	}
	
}
