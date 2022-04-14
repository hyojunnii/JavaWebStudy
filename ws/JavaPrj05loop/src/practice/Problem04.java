package practice;

import java.util.Scanner;

public class Problem04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int input = sc.nextInt();
			if (input == 0) break; // 반복문 즉시 탈출
			System.out.println(input);
		}
	}

}
