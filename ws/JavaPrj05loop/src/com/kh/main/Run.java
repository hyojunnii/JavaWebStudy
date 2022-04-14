package com.kh.main;

public class Run {

	public static void main(String[] args) {

		// 제어문 - 조건문, 반복문

		// 반복문 (for, while, do-while) continue, break

		// while : 조건식이 true일동안 실행
		int cnt = 0;
		while (cnt < 10) {
			System.out.println("hi");
			cnt = cnt + 1;
		}

		// for
		for (int i = 0; i < 10; i++) {
			System.out.println("hello");
		}

		// do - while : 한 번은 무조건 실행
		int x = 3;
		do {
			System.out.println("hihello");
			x++;
		} while (x < 3);

	}

}
