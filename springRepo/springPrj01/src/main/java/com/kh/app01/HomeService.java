package com.kh.app01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
	
	//@Autowired
	private HomeDao dao;
	
	@Autowired
	public void setDao(HomeDao dao) {
		System.out.println("service > setter called...");
		this.dao = dao;
	}
	
//	@Autowired
//	public HomeService(HomeDao dao) {
//		System.out.println("홈 서비스 태어남~");
//		this.dao = dao;
//	}

	public int home() {
		System.out.println("service호출됨~");
		int result = dao.home();
		return result;
	}
	
}
