package codeup;

import java.util.Scanner;

public class Codeup11 {

	public static void main(String[] args) {
		
		// 1351
		
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i = a; i <= b; i++) {	
			for(int n = 1; n <= 9; ++n) {
				System.out.println(i + "*" + n + "=" + (i*n));
			}
		}
	}
}
