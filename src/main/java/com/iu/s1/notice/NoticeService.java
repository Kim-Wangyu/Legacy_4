package com.iu.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.bankbook.BankBookDTO;
import com.iu.s1.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	//update
	public int update(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.update(noticeDTO);
	}
	
	
	//delete
	public int delete(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.delete(noticeDTO);
	}
	
	//insert
	//add
	public int add(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.add(noticeDTO);
	}
	
	//detail
	public NoticeDTO detail(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.detail(noticeDTO);
	}
	
	
	//list
	public List<NoticeDTO> list(Pager pager) throws Exception{
		
		pager.makeRow();
		
		Long totalCount = noticeDAO.total(pager);
		pager.makeNum(totalCount);
		
		List<NoticeDTO> ar = noticeDAO.list(pager);
		
		return ar;
	}

	
	
	
}
