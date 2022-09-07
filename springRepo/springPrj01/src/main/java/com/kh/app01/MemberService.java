package com.kh.app01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public int login() {
		int result = dao.login();
		return result;
	}
}
