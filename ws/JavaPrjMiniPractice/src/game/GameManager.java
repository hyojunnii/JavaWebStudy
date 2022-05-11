package game;

import util.InputUtil;

public class GameManager {

	public void gameStart() {
		//번호 고르게 하기
		System.out.println("1 : 업다운게임");
		System.out.println("2 : 업다운게임");
		System.out.println("3 : 업다운게임");
		
		System.out.print("게임 번호 선택 : ");
		int gameNum = InputUtil.inputInt();

//		Scanner sc = new Scanner(System.in);
//		String gameNumStr = sc.nextLine();
//		int gameNum = Integer.parseInt(gameNumStr);
		
		switch(gameNum) {
		case 1: updownGameStart();
			break;
		case 2:
			break;
		case 3:
			break;
		default: // error
		}
	}
	
	private void updownGameStart() {
		System.out.println("1~100사이의 숫자를 하나 고르세요");
		
		//입력받기
		//컴퓨터 랜덤 숫자 생성
		
		//1. 업다운 비교, 결과 출력
		//2. 입력받기
		//맞출때까지 무한반복
		
		System.out.println("이겼습니다 ~~");
	}
	
	
}
