package com.kh.app01;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	public int login() {
		System.out.println("로그인 dao 호출!");
		return 1;
	}
}
