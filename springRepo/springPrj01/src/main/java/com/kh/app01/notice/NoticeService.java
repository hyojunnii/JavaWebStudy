package com.kh.app01.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDao dao;
	
	public int write(NoticeVo vo) {
		int result = dao.write(vo);
		return result;
	}

}
