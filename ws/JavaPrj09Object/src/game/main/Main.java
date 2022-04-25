package game.main;

import java.util.Scanner;

import rcp.main.GameManagerRcp;
import updown.main.GameManagerUpDown;

public class Main {

	public static void main(String[] args) {

		// 스캐너 클래스 파일 이용해서 객체 생성, sc라는 변수에 할당
		Scanner sc = new Scanner(System.in);
		
		// 게임 2개
		// UpDown
		// Rcp
		
		// 게임매니저 채용 (객체 준비)
		GameManagerUpDown gmUpdown = new GameManagerUpDown();
		GameManagerRcp gmRcp = new GameManagerRcp();
		
		System.out.println("1 : updown");
		System.out.println("2 : rcp");
		
		int input = sc.nextInt();
		
		if(input == 1) {
			gmUpdown.gameStart();
		} else if(input == 2) {
			gmRcp.gameStart();
		}
	}

}
