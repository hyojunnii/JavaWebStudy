package com.kh.app12.bank.dao;

import org.mybatis.spring.SqlSessionTemplate;

public interface BankDao {
	int plus(SqlSessionTemplate sst, int money);
	
	int minus(SqlSessionTemplate sst, int money);
}
 