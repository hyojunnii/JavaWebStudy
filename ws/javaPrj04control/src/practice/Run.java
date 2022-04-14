package practice;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // ¿Ü¿ì±â

		int x = sc.nextInt();

		if (x > 0) {
			System.out.println("+");
		} else if (x == 0) {
			System.out.println("0");
		} else {
			System.out.println("-");
		}

	}

}
