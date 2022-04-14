package practice;

import java.util.Scanner;

public class Codeup04 {

	public static void main(String[] args) {
		
		//1405 숫자 로테이션
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 0 1 2 3 4 5
		// 1 2 3 4 5 0
		
	
			for(int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			
	}

}
