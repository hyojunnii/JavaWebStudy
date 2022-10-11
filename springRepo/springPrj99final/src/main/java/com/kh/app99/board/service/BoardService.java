package com.kh.app99.board.service;

import java.util.List;

import com.kh.app99.board.vo.BoardVo;
import com.kh.app99.common.PageVo;

public interface BoardService {

	//게시글 작성
	int write(BoardVo vo);

	//목록 조회
	List<BoardVo> selectList(PageVo pv);

	//상세 조회
	BoardVo selectOne(String no);

	//게시글 수정
	int edit(BoardVo vo);

	//전체 게시글 갯수 조회
	int selectTotalCnt();

	//게시글 삭제
	int delete(String no);

}
