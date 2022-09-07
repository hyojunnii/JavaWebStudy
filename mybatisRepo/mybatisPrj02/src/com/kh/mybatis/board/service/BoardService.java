package com.kh.mybatis.board.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.dao.BoardDao;
import com.kh.mybatis.board.vo.BoardVo;
import com.kh.mybatis.common.PageVo;

import static com.kh.mybatis.common.SqlTemplate.*;

import java.util.List;
import java.util.Map;

public class BoardService {

	public int write(BoardVo vo) {
		
		SqlSession ss = getSqlSession();
		
		int result = new BoardDao().write(ss, vo);
	
		if(result == 1) {
			ss.commit();
		}
		
		ss.close();
		
		return result;
	}

	public List<BoardVo> selectList(PageVo pvo, Map<String, String> map) {
		
		SqlSession ss = getSqlSession();
		
		List<BoardVo> list = new BoardDao().selectList(ss, pvo, map);
		
		ss.close();
		
		return list;
	}

	public int selectListCount(Map<String, String> map) {
		
		SqlSession ss = getSqlSession();
		
		int result = new BoardDao().selectListCount(ss, map);
		
		ss.close();
		
		return result;
	}

}
