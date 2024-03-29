package com.kh.app99.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app99.board.vo.BoardVo;
import com.kh.app99.common.PageVo;

public interface BoardDao {

	//게시글 작성
	int insertBoard(SqlSessionTemplate sst, BoardVo vo);

	//목록 조회
	List<BoardVo> selectList(SqlSessionTemplate sst, PageVo pv);

	//상세 조회
	BoardVo selectOne(SqlSessionTemplate sst, String no);
	
	//조회수 증가
	int increaseHit(SqlSessionTemplate sst, String no);

	//게시글 수정
	int updateOne(SqlSessionTemplate sst, BoardVo vo);

	//전체 게시글 갯수 조회
	int selectCountAll(SqlSessionTemplate sst);

	//게시글 삭제
	int delete(SqlSessionTemplate sst, String no);

}
