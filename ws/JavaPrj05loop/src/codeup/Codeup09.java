package codeup;

import java.util.Scanner;

public class Codeup09 {

	public static void main(String[] args) {
		
		// 1352
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		for(int j = 0; j < n; ++j) {
			for(int i = 0; i < n; ++i) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
