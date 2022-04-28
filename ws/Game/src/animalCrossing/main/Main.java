package animalCrossing.main;

import java.util.Scanner;

import animalCrossing.game.MakeMoney;
import animalCrossing.game.MakeMoneyTool;
import animalCrossing.game.ResidentInfo;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
					
		/*
		 * 빚갚아요 동물의 숲
		 * 
		 * 1. 주민대표 이름 정하기 
		 * 
		 * 2. 집 짓기 (텐트 - 원룸 - 투룸 - 쓰리룸 - 옥탑방 - 지하실)
		 * 3. 대출
		 *  
		 * 4. 빚 갚기
		 * - 과일팔기 : 1개 1000원, 알파벳 입력   //여기까지
		 * - 무주식 : 랜덤수 이용 			
		 * 5. 증축 물어보기 (반복)
		 * 
		 * 6. 지하실 완공하면 끝
		 */
		
		
		
		ResidentInfo userInfo = new ResidentInfo();
		MakeMoney makeMoney = new MakeMoney();
		MakeMoneyTool moneyTool = new MakeMoneyTool();
		
		
		System.out.println("====== 빚갚아요 동물의숲 ======");
		System.out.println();
		System.out.println("만나서 반가워구리! Hook.Int 사장 너굴이야구리");
		System.out.println("내집마련 플랜에 참가하게 된 걸 환영해구리!!");
		
		
		
		//이름 묻기
		System.out.println("그럼 먼저 입주 신청서를 작성해보자구리! 너의 이름은 뭐야구리? ▼");
		userInfo.setPlayer(sc.nextLine());
		String user = userInfo.getPlayer();
		System.out.println("좋아 " + user + "(이)구나! 반가워구리!");
		
		System.out.println();
//		System.out.println("-------------------------------");
		System.out.println("--------- 텐트 설치중 ---------");
//		System.out.println("-------------------------------");
		
		System.out.println();
		System.out.println("그럼 " + user + ", 당분간은 이 텐트에서 자게 될거야!");
		System.out.println("아직은 집을 지을만한 돈이 충분하지 않아...");
		System.out.println(user + "(이)가 마을을 잘 도와주면 언젠가는 큰 집을 지을 수가 있어구리!");
		System.out.println();
		System.out.println("집을 짓기 위해서는 자금이 필요해~ 50,000원 정도 있으면 좋을거같은데-!");
		System.out.println("돈은 우리 마을의 특산품인 사과를 팔아 얻을 수 있고, 특별한 무..가 있다고도 들었어구리!");
		System.out.println("다 모으게 되면 나에게 말해줘!");
		System.out.println();
		
		//돈 벌기
		do {
			moneyTool.moneyTool();
			System.out.println("-------------------------------");
			System.out.println("게임을 그만두었습니다.");
			System.out.println("1. 다시 벌기 2. 증축하기(미구현) 3. 잔액보기(?) 4. 종료하기");
			int stop = sc.nextInt();
			
			if (stop == 1) {
				
				continue;
				
			} else if (stop == 2) {
				//미구현
				break;
				
			} else if (stop == 3) {
				
				int totalMoney = userInfo.getTotalMoney();
				System.out.println();
				System.out.println("잔액 : " + totalMoney + "원");
				
			} else {
				break;
			}
			
		} while(true);
		
	}
		
		
		
		
		
		
		
		
		
}


