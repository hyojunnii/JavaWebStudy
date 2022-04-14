package codeup;

import java.util.Scanner;

public class Codeup07 {

	public static void main(String[] args) {
		
		// 1253
		
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (a < b) {
			for(int i = a; i <= b; ++i) {
				System.out.print(i + " ");
			}
		} else {
			for(int i = b; i <= a; ++i) {
				System.out.print(i + " ");
			}
		}
	}	
}
