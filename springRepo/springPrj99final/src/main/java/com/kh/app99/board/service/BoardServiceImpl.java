package com.kh.app99.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app99.board.dao.BoardDao;
import com.kh.app99.board.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao dao;
	private final SqlSessionTemplate sst;
	
	@Autowired
	public BoardServiceImpl(BoardDao dao, SqlSessionTemplate sst) {
		this.dao = dao;
		this.sst = sst;
	}
	
	//게시글 작성
	@Override
	public int write(BoardVo vo) {
		return dao.insertBoard(sst, vo);
	}

	//목록조회
	@Override
	public List<BoardVo> selectList() {
		return dao.selectList(sst);
	}

	//상세조회
	@Override
	public BoardVo selectOne(String no) {
		int result = dao.increaseHit(sst, no);
		if(result == 1) {
			return dao.selectOne(sst, no);
		} else {
			return null;
		}
	}

	//게시글 수정
	@Override
	public int edit(BoardVo vo) {
		return dao.updateOne(sst, vo);
	}

}//class
