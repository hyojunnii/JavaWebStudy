package codeup;

import java.util.Scanner;

public class Codeup10 {

	public static void main(String[] args) {
		
		// 1353
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		for(int j = 0; j <= n; ++j) { // x : 1~n
			
			for(int i = 0; i < j; ++i) { // x번만큼 *출력
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
