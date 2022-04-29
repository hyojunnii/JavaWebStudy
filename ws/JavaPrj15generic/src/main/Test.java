package main;

import java.util.*;

public class Test {

	/*
	 * 제네릭 : 타입제한
	 * 예시 : List<String> = new ArrayList<>();
	 * List<String> = new AttayList<String>();
	 */
	
	public void test() {
		
		List<Integer> al = new ArrayList<Integer>();
//		al.add("asd"); - 제네릭때문에 안됨
		al.add(10);
		al.add(20);
		al.add(30);
		
		//리스트에 있는 모든 데이터 더한값
		//자동으로 int타입으로 변환해서 나옴
//		int x1 = al.get(0);
//		int x2 = al.get(1);
//		int x3 = al.get(2);
//		
//		int result = x1 + x2 + x3;
		
		int result = 0;
//		for(int i = 0;i < al.size(); i++) 
		
		//enhanced for문, 향상된 for문 (컬렉션, 배열 모두 사용가능)
		for(int elem : al)
		{
//			int temp = al.get(i);
			int temp = elem;
			result += temp;
		}
		System.out.println(result);
		
	}
	
	
}//class
