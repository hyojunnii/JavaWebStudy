package com.kh.object;

import vo.Person;

public class ObjectTest {

	public void test() {
		//getClass
		String s = "abc";
		System.out.println(s.getClass());
		
		Person p = new Person("심원용", 1, 1, 1, 'M');
		System.out.println(p.getClass());
	}
	
	public void test2() {
		//hashCode : 객체의 ID값을 정수로 출력
		// 문자열은 다르게 동작 (해시값 같음)
		Person p = new Person("심원용", 1, 1, 1, 'M');
		System.out.println(p.hashCode());
		
		Person p2 = new Person("심원용", 1, 1, 1, 'M');
		System.out.println(p2.hashCode());
	
		String s1 = "문자열1";
		System.out.println(s1.hashCode());

		String s2 = new String("문자열1");
		System.out.println(s2.hashCode());
	}
	
	public void test3() {
		//toString : 해당 객체 확인
		// Object에 작성되어 있고 객체가 기본적으로 호출하는 메소드
		Person p = new Person("심원용", 1, 1, 1, 'M');
		System.out.println(p.toString());
		System.out.println(p);
	}
	
	
	
}
