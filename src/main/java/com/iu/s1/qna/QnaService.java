package com.iu.s1.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.iu.s1.qna.QnaDAO;
import com.iu.s1.qna.QnaDTO;
import com.iu.s1.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	// update
	public int update(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.update(qnaDTO);
	}

	// delete
	public int delete(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.delete(qnaDTO);
	}
	
	// detail
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception {

		return qnaDAO.detail(qnaDTO);
	}

	// insert
	// add
	public int add(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.add(qnaDTO);
	}
	
	//list
	public List<QnaDTO> list() throws Exception{
		
		List<QnaDTO> ar = qnaDAO.list();
		
		return ar;
	}
}
