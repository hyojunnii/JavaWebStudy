package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Test {
	
	Person p1 = new Person("심원용", 20, 'M');
	Person p2 = new Person("심투용", 20, 'M');
	Person p3 = new Person("심삼용", 20, 'M');

	String s1 = "aaa";
	String s2 = "bbb";
	String s3 = "ccc";
	
	//List - 배열과 다르게 사이즈를 마음대로 조정 가능
	public void testList() {
		
		//ArrayList
//		ArrayList al = new ArrayList();
//		al.add(p1);
//		al.add(p2);
//		al.add(p3);
//		al.add(s1);
//		al.add(s2);
//		al.add(s3);
//
//		System.out.println(al.get(0));
//		System.out.println(al.get(2));
//		System.out.println(al.get(5));
		
		//LinkedList
		LinkedList list = new LinkedList();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.get(5));
	}
	
	//Set : 인덱스, 중복이 없음, 포함여부 확인 쉬움
	public void testSet() {
		//HashSet
		HashSet hs = new HashSet();
		hs.add(p1);
		hs.add(p2);
		hs.add(p3);
		hs.add(s1);
		hs.add(s2);
		hs.add(s3);
		
		System.out.println(hs);
	}
	
	//Map : key:value 형태
	public void testMap() {
		//HashMap
		HashMap map = new HashMap();
		
		map.put("first", p1);
		map.put("second", p2);
		map.put("third", p3);
		
		System.out.println(map.get("first"));
	}
	
	
	
	
	
	
}//class
