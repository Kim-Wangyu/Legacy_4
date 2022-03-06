package com.iu.s1.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyJunitTest;




public class QnaDAOTest extends MyJunitTest {
	
	@Autowired
	private QnaDAO qnaDAO;
	int result = 0;
	
	@Test
	public void add() throws Exception {
		for (int i = 10; i < 80; i++) {
			QnaDTO qnaDTO = new QnaDTO();
		
			qnaDTO.setTitle("title" + i); // 물음표,# 들어가는것만 입력, 넘버는 SEQ로 들어가니까 안함
			qnaDTO.setContents("contents" + i);

			qnaDTO.setWriter("writer"+i); // 총 3자리, 소숫점 2자리
			

		 result = qnaDAO.add(qnaDTO);
		}
		System.out.println("Insert 끝");
		 assertNotEquals(0, result); //1이 오길 희망함, 예상함 (왼쪽은 희망값, 오른쪽은 실제 결과 값)
	}

}
