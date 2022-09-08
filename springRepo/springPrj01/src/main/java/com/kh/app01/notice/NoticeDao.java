package com.kh.app01.notice;

import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao {

	public int write(NoticeVo vo) {
		System.out.println("dao");
		System.out.println("title : " + vo.getTitle());
		System.out.println("content : " + vo.getContent());
		
		return 777;
	}

}
