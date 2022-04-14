package practice;

import java.util.Scanner;

public class Codeup02 {

	public static void main(String[] args) {
		
		//1094 입력 숫자 거꾸로 출력하기
		
		Scanner sc = new Scanner(System.in);
		// 5
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		// 0 1 2 3 4
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// 5-1
		for(int i = n-1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
