package com.kh.app99.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app99.board.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	//게시글 작성
	@Override
	public int insertBoard(SqlSessionTemplate sst, BoardVo vo) {
		return sst.insert("boardMapper.insertBoard", vo);
	}

	//목록조회
	@Override
	public List<BoardVo> selectList(SqlSessionTemplate sst) {
		return sst.selectList("boardMapper.selectList");
	}

	//상세조회
	@Override
	public BoardVo selectOne(SqlSessionTemplate sst, String no) {
		return sst.selectOne("boardMapper.selectOne", no);
	}

	//조회수증가
	@Override
	public int increaseHit(SqlSessionTemplate sst, String no) {
		return sst.update("boardMapper.increaseHit", no);
	}
	

}
