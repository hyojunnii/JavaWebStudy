package codeup;

import java.util.Scanner;

public class Codeup01 {

	public static void main(String[] args) {
		
		// 1153
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (a > b) {
			System.out.println(">");
		} else if (a < b) {
			System.out.println("<");
		} else {
			System.out.println("=");
		}
	}
}
