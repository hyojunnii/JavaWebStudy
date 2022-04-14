package codeup;

import java.util.Scanner;

public class Codeup05 {

	public static void main(String[] args) {
		
		// 1218
		
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if (a == b && a == c) {
			System.out.println("Á¤»ï°¢Çü");
		} else if (a == b || a == c || b == c) {
			System.out.println("ÀÌµîº¯»ï°¢Çü");
		} else if (a*a + b*b == c*c) {
			System.out.println("Á÷°¢»ï°¢Çü");
		} else if (a <= b && b <= c) {
			System.out.println("»ï°¢Çü");
		} else {
			System.out.println("»ï°¢Çü¾Æ´Ô");
		}
	}
}
