package practice;

import java.util.Scanner;

public class UpdownGame {

	public static void main(String[] args) {

		// 업다운게임

		Scanner sc = new Scanner(System.in);

		// 컴퓨터가 1~50중에 숫자 하나 생각하게 하기
		int x = (int) (Math.random() * 50) + 1;
				// casting 형변환 : 타입 변경
				// Math.random() : 0~10사이의 숫자 반환

		// 횟수 측정 변수
		int cnt = 0; 

		while (true) {
			// 컴퓨터한테 숫자 물어보기
			int num = sc.nextInt();
			// 횟수 증가
			cnt++;
			
			// 컴퓨터가 답변하기
			if (num < x) {
				System.out.println("up");
			} else if (num > x) {
				System.out.println("down");
			} else {
				System.out.println("correct");
				System.out.println(cnt + "번 시도했습니다.");
				break;
			}
		}
	}
}
