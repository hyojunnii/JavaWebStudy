package practice;

import java.util.Scanner;

public class Codeup01 {

	public static void main(String[] args) {
		
		//1093 숫자별 입력 횟수 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		// 배열만들기
		int[] cnt = new int[23];

		// 횟수 입력
		int n = sc.nextInt();
		
		// 횟수 측정
		for(int i = 0;i < n;i++) {
			// 부른 숫자 입력받고
			int x = sc.nextInt();
			// 배열칸에 1 더하기
			// 0부터 시작하기 때문에 -1칸		
			cnt[x-1] += 1;
		}
		
		// 배열 출력
		for (int i = 0;i < 23; i++) {
			System.out.println(cnt[i]);
		
		}
		
		
	}

}
