package codeup;

import java.util.Scanner;

public class Codeup04 {
	
	public static void main(String[] args) {
		
		// 1203
		
		Scanner sc = new Scanner(System.in);
		
		int bmi = sc.nextInt();

		if (bmi <= 10) {
			System.out.println("정상");
		} else if (bmi <= 20) {
			System.out.println("과체중");
		} else {
			System.out.println("비만");
		}
	}
}
