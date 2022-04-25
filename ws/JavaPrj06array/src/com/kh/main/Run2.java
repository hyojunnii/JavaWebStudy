package com.kh.main;

public class Run2 {

	public static void main(String[] args) {

		// 다차원 배열
		// 2차원 배열
		int[][] a = new int[3][3];
		
		a[0][1] = 1; // 1행 2열

		
		
		int[][] b = new int[3][]; // 유동적 배열 가능, 앞칸은 참조형 변수(주소값 들어감)
		
		b[0] = new int[4];  // b[0] 안에 배열
		
		b[0][0] = 10; // b[0] -> 배열주소확인하고이동 -> [0]번칸
		b[0][1] = 20; 
		b[0][2] = 30; 
		b[0][3] = 40; 

		System.out.println(a[0][0]);
		
	}

}
