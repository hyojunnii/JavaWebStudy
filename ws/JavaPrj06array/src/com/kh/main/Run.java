package com.kh.main;

public class Run {

	public static void main(String[] args) {

		// 배열
		/*
		 * 1. 배열 변수 선언 		//int[] a;
		 * 2. 배열 생성 			// new int[3];
		 * 3. 배열의 각 요소에 접근 //a[0];
		 */
		
		// 선언 : 타입[] 변수명; 타입 변수명[];
		// 참조형 변수 a
//		int[] a;
		
		// 생성 : 변수 = new 타입[인덱스길이];
		int[] a = new int[5];
		
		// 초기화 : 선언, 할당 동시에 하는 것
//		int[] a = {10,20,30,40,50};
//		int[] a = new int[] {10,20,30,40,50};		
		
		// element에 접근, 할당
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		a[3] = 40;
		a[4] = 50;
		
		// 배열 길이 체크
		System.out.println(a.length);
		
		// 접근
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);
		System.out.println(a[4]);
		
	}
}

