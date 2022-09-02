package com.kh.mybatis.common;

public class MyEncryptor implements EncryptorInter {
	
	//암호화알고리즘
	@Override
	public String enc(String data) {
		String result = "aaa" + data + "zzz";
		return result;
	}
}
