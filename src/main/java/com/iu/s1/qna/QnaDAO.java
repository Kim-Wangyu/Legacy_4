package com.iu.s1.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.qna.QnaDTO;
import com.iu.s1.util.Pager;

@Repository
public class QnaDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.qna.QnaDAO.";
	
	//update
	public int update(QnaDTO qnaDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"update",qnaDTO);
	}
	
	//detail
	public QnaDTO detail(QnaDTO qnaDTO)throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"detail", qnaDTO);
	}
	

	
	//list
	public List<QnaDTO> list() throws Exception{
		String name="";
		return sqlSession.selectList(NAMESPACE+"list");
		
	}
	
	//insert
	public int add(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", qnaDTO);
	}
	
	
	
	//delete
	public int delete(QnaDTO qnaDTO)throws Exception{
		
		return sqlSession.delete(NAMESPACE+"delete", qnaDTO);
	}
}
