package practice;

import java.util.Scanner;

public class Problem01 {

	public static void main(String[] args) {

		// 1403 부른 숫자 두번 출력하기

		Scanner sc = new Scanner(System.in);

		// n받기
		int n = sc.nextInt();

		// 배열 만들기
		int arr[] = new int[n];

		// n번 입력받기
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 배열 두 번 출력
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < n; i++) {
				System.out.println(arr[i]);
			}
		}

	}

}
