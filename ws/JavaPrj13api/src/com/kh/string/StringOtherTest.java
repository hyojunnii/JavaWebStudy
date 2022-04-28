package com.kh.string;

	//1. String
	//2. StringBuffer
	//3. StringBuilder

public class StringOtherTest {

	public void test() {
		//String
		String str = new String("zzz");
		String str2 = "zzz";
		str += "123"; //zzz123
		
		//StringBuffer : thread safe
		StringBuffer sb = new StringBuffer("buffer~");
		sb.append("123");
		System.out.println(sb);
		
		//StringBuilder : thread unsafe (동시접근)
		StringBuilder sbd = new StringBuilder("builder~");
		sbd.append("123");
		System.out.println(sbd);
		
	}
	
}//class
