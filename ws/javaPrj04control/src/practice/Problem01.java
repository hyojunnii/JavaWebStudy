package practice;

import java.util.Scanner;

public class Problem01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		if (x % 2 != 0) {
			System.out.println("È¦¼ö");
		} else if (x == 0) {
			System.out.println("0");
		} else {
			System.out.println("Â¦¼ö");
		}

	}

}
