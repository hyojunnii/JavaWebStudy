package com.kh.mybatis.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.dao.BoardDao;
import com.kh.mybatis.board.vo.BoardVo;
import com.kh.mybatis.common.SqlTemplate;

public class BoardService {
	//게시글 작성
	public int insert(BoardVo vo) {
		
		SqlSession ss = SqlTemplate.getSqlSession();
		
		int result = new BoardDao().insert(ss, vo);
		
		if(result == 1) {
			ss.commit();
		}
		ss.close();
		
		return result;
	}

	//게시글 전체조회
	public List<BoardVo> selectList() {
		
		SqlSession ss = SqlTemplate.getSqlSession();
		
		List<BoardVo> list = new BoardDao().selectList(ss);
		
		ss.close();
		
		return list;
	}

}
