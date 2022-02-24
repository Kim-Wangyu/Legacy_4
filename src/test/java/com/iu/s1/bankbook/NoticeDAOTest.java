package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.iu.s1.MyJunitTest;
import com.iu.s1.notice.NoticeDAO;
import com.iu.s1.notice.NoticeDTO;
import com.iu.s1.util.Pager;

public class NoticeDAOTest extends MyJunitTest {

	
	
	private NoticeDAO noticeDAO;
	
	
	// list
	@Test
	public void list() throws Exception {
		Pager pager = new Pager();
		pager.setPerPage(5L);
		pager.makeRow();
		List<NoticeDTO> ar = noticeDAO.list(pager);
		System.out.println(ar.get(0).getNum());
		System.out.println(ar.get(4).getNum());
		assertEquals(5, ar.size());
	}


}
