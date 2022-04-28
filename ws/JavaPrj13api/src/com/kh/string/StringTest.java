package com.kh.string;

public class StringTest {

	public void test() {
		//charAt : 문자열에서 특정인덱스의 문자를 가져옴
		String s = "abcdefg";
		
		char ch = s.charAt(0);
		System.out.println("ch : " + ch);
	}

	public void test2() {
		//compareTo : 사전순 정렬, 앞이면 음수 같으면 0 뒤면 양수
		String s = "a";
		String s2 = "b";
		
		int x = s.compareTo(s2);
		System.out.println(x);
	}
	
	public void test3() {
		//concat : 문자열 합쳐줌
		String s = "abc";
		String s2 = "zzz";
		
		String x = s.concat(s2);
		System.out.println(x);
	}
	
	public void test4() {
		//equals : 문자열 같은지 비교
		String s = "abc";
		String s2 = "zzz";
		System.out.println(s.equals(s2));
	}
	
	public void test5() {
		//equalsIgnoreCase : 대소문자 무시하고 같은지 비교
		String s = "abc";
		String s2 = "ABC";
		System.out.println(s.equalsIgnoreCase(s2));
	}
	
	public void test6() {
		//length : 문자열의 길이를 정수값으로 리턴
		String s = "ab c";
		System.out.println(s.length());
	}
	
	public void test7() {
		//replace : 특정 문자를 원하는 문자로 바꿔줌
		String s = "abc123";
		String x = s.replace('c', 'S');
		System.out.println(s); //기존 문자열 그대로
		System.out.println(x);
	}
	
	public void test8() {
		//substring : 문자열의 특정 범위를 잘라냄
		String s = "abc12345";
//		String x = s.substring(5); //시작인덱스 ~ 끝
		String x = s.substring(2, 5); //시작인덱스 ~ 특정지점 2 <= x < 5
		System.out.println(x);
	}

	public void test9() {
		//toUpperCase
		String s = "abc123";
		String x = s.toUpperCase();
		System.out.println(x);
		String low = test10(x);
		System.out.println(low);
	}
	
	public String test10(String str) {
		//toLowerCase
		return str.toLowerCase();
	}
		
}//class
