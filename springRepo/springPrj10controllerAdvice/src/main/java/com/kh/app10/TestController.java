package com.kh.app10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@KhAno
public class TestController {
	
	@GetMapping("test01")
	public String test01() {
		return "fafafafaf";
	}
	@GetMapping("test02")
	public String test02() {
		int x = 10 / 0;
		return "fafafafaf";
	}
	@GetMapping("test03")
	public String test03() {
		int x = Integer.parseInt("zzz");
		return "fafafafaf";
	}
	
}
