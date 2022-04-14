package practice;

import java.util.Scanner;

public class RCPgame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("##가위바위보 게임##");

		int cnt = 0;
		
//		boolean isUserWin = false;
//		while(!isUserwin) {}
		
		while (true) {
			int num = (int) ((Math.random() * 3) + 1);

			System.out.println();
			System.out.println("1.가위 2.바위 3.보");

			int input = sc.nextInt();
			cnt++;

			String com;
			String user;

			if (num == 1) {
				com = "가위";
			} else if (num == 2) {
				com = "바위";
			} else {
				com = "보";
			}
			if (input == 1) {
				user = "가위";
			} else if (input == 2) {
				user = "바위";
			} else {
				user = "보";
			}

			if (input > 3) {
				System.out.println("다시 입력하세요.");
				cnt = 0;

			} else {
				System.out.println("컴퓨터 : " + com);
				System.out.println("사용자 : " + user);

				if (input == num) {
					System.out.println("-비겼습니다-");

				} else if (input == 1) {
					if (num == 3) {
						System.out.println("-사용자 승-");
						System.out.println();
						System.out.println(cnt + "번 만에 승리하셨습니다.");
						System.out.println("다시하시겠습니까? 1.예");
						int yn = sc.nextInt();
						if (yn == 1) {
							cnt = 0;
							continue;
						} else {
							break;
						}
					} else {
						System.out.println("-컴퓨터 승-");
					}

				} else if (input == 2) {
					if (num == 1) {
						System.out.println("-사용자 승-");
						System.out.println();
						System.out.println(cnt + "번 만에 승리하셨습니다.");
						System.out.println("다시하시겠습니까? 1.예");
						int yn = sc.nextInt();
						if (yn == 1) {
							cnt = 0;
							continue;
						} else {
							break;
						}
					} else {
						System.out.println("-컴퓨터 승-");
					}

				} else if (input == 3) {
					if (num == 2) {
						System.out.println("-사용자 승-");
						System.out.println();
						System.out.println(cnt + "번 만에 승리하셨습니다.");
						System.out.println("다시하시겠습니까? 1.예");
						int yn = sc.nextInt();
						if (yn == 1) {
							cnt = 0;
							continue;
						} else {
							break;
						}
					} else {
						System.out.println("-컴퓨터 승-");
					}
				}
				
				
			}
		}

	}
}
