package practice;

import java.util.Scanner;

public class Problem03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		if ((x % 4 == 0 && x % 100 != 0) || (x % 400 == 0)) {
			System.out.println(x + "년은 윤년입니다.");
		}

	}

}
