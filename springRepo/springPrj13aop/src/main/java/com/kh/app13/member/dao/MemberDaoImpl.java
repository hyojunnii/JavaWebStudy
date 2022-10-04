package com.kh.app13.member.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Override 
	public int join(String id, String pwd) {
		System.out.println("멤버dao호출 ~");
		return 1;
	}
	
}
