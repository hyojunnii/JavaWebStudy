package codeup;

import java.util.Scanner;

public class Codeup02 {
	
	public static void main(String[] args) {
		
		// 1156
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		if (x % 2 != 0) {
			System.out.println("odd");
		} else {
			System.out.println("even");
		}
	}

}
