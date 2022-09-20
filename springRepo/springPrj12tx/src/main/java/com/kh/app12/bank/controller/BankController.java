package com.kh.app12.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app12.bank.service.BankService;

@Controller
@RequestMapping("bank")
public class BankController {
	
	@Autowired
	private BankService service;
	
	@GetMapping("send")
	public String send() {
		return "bank/send";
	}
	
	@PostMapping("send")
	public String send(int money) {
		
		System.out.println(money);
		
		int result = service.send(money);
		
		return result == 1 ? "성공" : "실패";
	}
	
}//class
