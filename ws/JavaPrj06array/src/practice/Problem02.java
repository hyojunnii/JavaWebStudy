package practice;

import java.util.Scanner;

public class Problem02 {

	public static void main(String[] args) {
		
		// 1095 입력된 번호 중 가장 작은 숫자 찾기
		
		Scanner sc = new Scanner(System.in);
		
		int[] memo = new int[24]; // 0-23
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			// 출석번호 확인
			int x = sc.nextInt();
			// x번 칸에 가서 체크
			memo[x] = 1;
		}
		
		// 1이 적혀있는 첫칸 찾기
		for(int i = 1; i <= 23; i++) {
			if(memo[i] == 1) {
				System.out.println(i);
				break;
			}
		}
		
//		int min = 24;
//		
//		for(int i = 0; i < n; i++) {
//			a[i] = sc.nextInt();
//			if (a[i] < min) {
//				min = a[i];
//			}
//		}
//		System.out.println(min);
		
	}

}
