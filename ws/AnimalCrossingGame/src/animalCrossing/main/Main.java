package animalCrossing.main;

import java.util.Scanner;

import animalCrossing.game.MakeMoney;
import animalCrossing.game.MakeMoneyTool;
import animalCrossing.game.ResidentInfo;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
					
		/*
		 * 돈벌어요 동물의 숲
		 * 
		 * 1. 주민대표 이름 정하기 
		 * 
		 * 2. 돈벌기
		 * - 과일팔기 : 1개 1000원, 알파벳 입력
		 * - 무주식 : 랜덤수 이용 		
		 * 
		 * 3. 다시하기 / 잔액확인 / 종료
		 * 	
		 */
		
		ResidentInfo userInfo = new ResidentInfo();
		MakeMoneyTool moneyTool = new MakeMoneyTool();
		
		
		System.out.println("====== 돈벌어요 동물의숲 ======");
		System.out.println();
		System.out.println("만나서 반가워구리! Hook.Int 사장 너굴이야구리");
		System.out.println("일을 하러 왔구나!!");
		System.out.println("너의 이름은 뭐야구리? ▼");
		userInfo.setPlayer(sc.nextLine());
		String user = userInfo.getPlayer();
		System.out.println("좋아 " + user + "(이)구나! 반가워구리!");
		
		System.out.println();
		System.out.println("그럼 " + user + ", 돈을 버는 방법을 설명해줄게!");
		System.out.println("돈은 우리 마을의 특산품인 사과를 팔아 얻을 수 있고, 특별한 무..가 있다고도 들었어구리!");
		System.out.println();
		
		//돈 벌기
		do {
			moneyTool.moneyTool();
			System.out.println("게임을 그만두었습니다.");
			System.out.println("-------------------------------");
			System.out.println("1. 다시 벌기 2. 잔액보기 3. 종료하기");
			int stop = sc.nextInt();
			
			if (stop == 1) {
				
				continue;
				
			} else if (stop == 2) {
				
				System.out.println("현재 잔액은 " + moneyTool.totalMoney + "벨 입니다.");
				
			} else {
				break;
			}
			
		} while(true);
		
	}
		
		
} //CLASS


