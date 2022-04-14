package practice;

import java.util.Scanner;

public class Problem05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		for (int i = 1; i <= input; i++) {
			if (i % 2 == 0) {
				continue; // 반복탈출 후 다음반복 실행
			}
			System.out.println(i);
		}

	}

}
