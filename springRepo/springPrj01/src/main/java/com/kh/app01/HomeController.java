package com.kh.app01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//@Autowired 
	private HomeService s;
	
	@Autowired
	public void setS(HomeService s) {
		System.out.println("controller > setter called...");
		this.s = s;
	}
	
//	@Autowired
//	public HomeController(HomeService s) {
//		System.out.println("홈 컨트롤러 태어남~");
//		this.s = s;
//	}
	
	@RequestMapping("/")
	public String home() {
		
		System.out.println("controller호출됨~");
		int result = s.home();
		
		return "home";
	}
	
}
