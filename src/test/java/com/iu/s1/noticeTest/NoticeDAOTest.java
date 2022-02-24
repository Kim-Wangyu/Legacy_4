package com.iu.s1.noticeTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;
import com.iu.s1.notice.NoticeDAO;
import com.iu.s1.notice.NoticeDTO;

public class NoticeDAOTest extends MyJunitTest {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//@Test
	public void check() {
		assertNotNull(noticeDAO);
	}

	//list
	//@Test
	public void list() throws Exception{
		List<NoticeDTO> ar = noticeDAO.list();
		
		assertNotEquals(0, ar.size());
	}
	
	//insert
	@Test
	public void add()throws Exception{
		for(int i =0;i<10;i++) {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("NoticeTitle"+i);
		noticeDTO.setContents("NoticeCon"+i);
		noticeDTO.setWriter("Writer"+i);
		
		noticeDTO.setHit(2L+i);
		
		int result = noticeDAO.add(noticeDTO);
		}
	//	assertEquals(1, result);
	}
	
	//detail
	//@Test
	public void detail() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
	//	noticeDTO=noticeDAO.detail(1L)
		noticeDTO.setNum(1L);
		assertNotNull(noticeDTO);
	}
	
	
	//delete
	//@Test
	public void delete() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2L);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);
	}
}
