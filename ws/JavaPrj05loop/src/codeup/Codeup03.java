package codeup;

import java.util.Scanner;

public class Codeup03 {
	
	public static void main(String[] args) {
		
		// 1173
		
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		
//		if ( m < 30) {
//			h = h - 1;
//			m = m - 30;
//			m = m + 60;
//		} else {
//			m = m - 30;
//		}
		
		if (m >= 30) {
			System.out.println(h + " " + (m-30));
		} else {
			System.out.println((h-1) + " " + (60-(30-m)));
		
//		System.out.print(h);
//		System.out.println(" " + m);
		}
	}
}
