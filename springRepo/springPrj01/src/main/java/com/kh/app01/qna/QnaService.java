package com.kh.app01.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {
	
	@Autowired
	private QnaDao dao;
	
	/**
	 * 문의 작성 진행
	 */
	public int write(QnaVo vo) {
		//커넥션보류
		int result = dao.write(vo);
		//트랜잭션, close
		return result;
	}

}
