package com.iu.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.bankbook.BankBookDTO;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.notice.NoticeDAO.";

	// update
	public int update(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", noticeDTO);
	}

	// list
	public List<NoticeDTO> list() throws Exception {
		String name = "";
		return sqlSession.selectList(NAMESPACE + "list");

	}

	// insert
	public int add(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", noticeDTO);
	}

	// detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", noticeDTO);
	}

	// delete
	public int delete(NoticeDTO noticeDTO) throws Exception {

		return sqlSession.delete(NAMESPACE + "delete", noticeDTO);
	}
}
