package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;
import com.iu.s1.util.Pager;

public class BankBookDAOTest extends MyJunitTest {

	@Autowired
	private BankBookDAO bankBookDAO;

	// @Test
	public void check() {
		assertNotNull(bankBookDAO);
	}

	// Detail
	// @Test
	public void detail() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();

		bankBookDTO = bankBookDAO.detail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}

	// list
	@Test
	public void list() throws Exception {
		Pager pager = new Pager();
		pager.setPerPage(5L);
		pager.makeRow();
		List<BankBookDTO> ar = bankBookDAO.list(pager);
		System.out.println(ar.get(0).getBookNumber());
		System.out.println(ar.get(4).getBookNumber());
		assertEquals(5, ar.size());
	}

	// Insert
	// @Test
	public void addTest() throws Exception {
		for (int i = 0; i < 200; i++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("bookName" + i); // 물음표,# 들어가는것만 입력, 넘버는 SEQ로 들어가니까 안함
			bankBookDTO.setBookContents("contents" + i);

			double rate = Math.random(); // 0.0~1.0미만 0.12345678
			rate = rate * 100; // 123.45678
			int r = (int) rate; // 123
			rate = r / 100.0; // 1.23

			bankBookDTO.setBookRate(rate); // 총 3자리, 소숫점 2자리
			bankBookDTO.setBookSale(1);

			int result = bankBookDAO.add(bankBookDTO);

			if (i % 10 == 0) {
				Thread.sleep(1000); // 1초동안 멈추세요.
			}
		}
		System.out.println("Insert 끝");
		// assertEquals(1, result); //1이 오길 희망함, 예상함 (왼쪽은 희망값, 오른쪽은 실제 결과 값)
	}

	// delete
	// @Test
	public void delete() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(4L);
		int result = bankBookDAO.delete(bankBookDTO);
		assertEquals(1, result);
	}

}
