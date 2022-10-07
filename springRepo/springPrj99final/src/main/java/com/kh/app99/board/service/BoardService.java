package com.kh.app99.board.service;

import java.util.List;

import com.kh.app99.board.vo.BoardVo;

public interface BoardService {

	//게시글 작성
	int write(BoardVo vo);

	//목록 조회
	List<BoardVo> selectList();

	//상세 조회
	BoardVo selectOne(String no);

	//게시글 수정
	int edit(BoardVo vo);

}
