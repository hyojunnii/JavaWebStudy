package com.kh.mybatis.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.vo.BoardVo;
import com.kh.mybatis.common.PageVo;

public class BoardDao {

	public int write(SqlSession ss, BoardVo vo) {
		return ss.insert("boardMapper.write",vo);
	}

	public List<BoardVo> selectList(SqlSession ss, PageVo pvo, Map<String, String> map) {
		//offset : 몇개 건너뛸지
		//limit : 몇개 가져올지
		
		int offset = (pvo.getCurrentPage()-1) * pvo.getBoardLimit();
		int limit = pvo.getBoardLimit();
		
		RowBounds rb = new RowBounds(offset, limit);
		
		return ss.selectList("boardMapper.selectList", map, rb);
	}

	public int selectListCount(SqlSession ss, Map<String, String> map) {
		return ss.selectOne("boardMapper.selectListCount", map);
	}

}
