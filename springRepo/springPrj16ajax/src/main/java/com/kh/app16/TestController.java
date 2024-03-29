package com.kh.app16;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController //controller+responsebody
public class TestController {

	@GetMapping("test01")
	public String test01(String k1) {
		System.out.println("k1 :: " + k1);
		return "test01 ~";
	}
	
	@GetMapping(value = "test02", produces = "text/plain; charset=UTF-8")
	public String test02(String age) {
		
		int x = Integer.parseInt(age);
		if(x >= 20) {
			return "성인입니다.";
		} else {
			return "미성년입니다.";
		}
	}
	
	@GetMapping(value = "test03", produces = "application/json; charset=UTF-8")
	public String test03() {
		Gson gson = new Gson();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", "user01");
		map.put("pwd", "1234");
		
		String str = gson.toJson(map);
		
		return str;
	}
}
