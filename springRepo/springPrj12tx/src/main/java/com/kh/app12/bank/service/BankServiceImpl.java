package com.kh.app12.bank.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app12.bank.dao.BankDao;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankDao dao;
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Transactional(noRollbackFor = ArithmeticException.class)
	@Override
	public int send(int money) {
		
		System.out.println("service" + money);
		
		int result1 = dao.minus(sst, money);
		
		int result2 = dao.plus(sst, money);
		
		return result1 * result2; 
	}
}
