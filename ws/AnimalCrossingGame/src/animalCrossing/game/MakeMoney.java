package animalCrossing.game;

import java.util.Scanner;

public class MakeMoney {

	ResidentInfo userInfo = new ResidentInfo();
		
	Scanner sc = new Scanner(System.in);
	
	public int money;
	
	public void sellFruit() {
		System.out.println("과일을 따서 팔아보자!");
		System.out.println();
		System.out.println("---------- 게임 방법 ----------");
		System.out.println("사과는 한 개에 1000벨에 팔리고 있다.");
		System.out.println("따고싶은 갯수만큼 알파벳 'o'를 입력해보자! ▼");
		
		while(true) {
		String apple = sc.nextLine();
			//// o 만 인식은 모르겠음
			if(apple.contains("o")||apple.contains("O")) {
				
				System.out.println();
				System.out.println(apple.length() + "개를 땄다!");
				money = (apple.length() * 1000);
				System.out.println(money + "벨을 벌었다!");
				
				MakeMoneyTool.totalMoney = MakeMoneyTool.totalMoney + money;
				System.out.println("-------------------------------");
				System.out.println("현재 잔액 : " + MakeMoneyTool.totalMoney + "벨");
				
				System.out.println();
				System.out.println("더 따시겠습니까? 1. 예 2. 아니오 ▼");
				int re = sc.nextInt();
				System.out.println();

				if(re != 1) {break;}
				// int타입이라 문자 입력시 오류
				
			} else {
				System.out.println("알파벳 'o'를 입력하자! ▼");
				continue;
			}
		}
		
	}
		
	public int radishStock() {
		System.out.println("무주식을 해보자!");
		System.out.println();
		System.out.println("---------- 게임 방법 ----------");
		System.out.println("무는 90-110벨의 가격에 살 수 있으며 팔 때는 50-600벨 사이로 팔리고 있다.");
		System.out.println();
		
		//랜덤값의 무 사기 (90-110)
		int buyRadish = 0;
		
		System.out.println("----------- 무사기 ------------");
		while(true) {
			java.util.Random r = new java.util.Random();
			int randomInt = r.nextInt(90,110);
			System.out.println("현재 무값은 " + randomInt + "벨 입니다. 사시겠습니까? 1. 예 2. 아니오 ▼");
			
			int input = sc.nextInt();
			if (input == 1) {
				buyRadish = randomInt;
				break;
			} else if (input == 2) {
				continue;
			}
		}
		
		int numRadish = 0;
		
		while(true) {
			System.out.println("몇 개를 사시겠습니까? ▼");
			int num = sc.nextInt();
			System.out.println(num + "개의 무를 " + buyRadish + "벨로 삽니다.");
			int rTotal = num * buyRadish;
			System.out.println("총 " + rTotal + "벨입니다.");
			System.out.println();
			System.out.println("-------------------------------");
			System.out.println("현재 잔액은 " + MakeMoneyTool.totalMoney + "벨 입니다.");
			System.out.println("구매하시겠습니까? 1. 예 2. 아니오 ▼");
			int yesNo = sc.nextInt();
			if (yesNo == 1) {
				if (MakeMoneyTool.totalMoney - rTotal < 0) {
					System.out.println("잔액이 부족합니다.");
					System.out.println();
					System.out.println("수량을 다시 입력하시겠습니까? 1. 예 2. 아니오 ▼");
					int input = sc.nextInt();
					if (input == 1) {
						continue;
					} else {
						return 0;
					}
				} else {
					MakeMoneyTool.totalMoney = MakeMoneyTool.totalMoney - rTotal;
					System.out.println("남은 잔액 : " + MakeMoneyTool.totalMoney + "벨 입니다.");
					numRadish = num;
					break;
				}
			} else if(yesNo == 2) {
				continue;
			}
		}
		System.out.println();
		System.out.println("----------- 무팔기 ------------");
		
		//컴퓨터가 랜덤 무값 제시 (50-600)
		int sellRadish = 0;
		
		while(true) {
			java.util.Random r = new java.util.Random();
			int randomInt = r.nextInt(50,600);
			System.out.println("현재 무값은 " + randomInt + "벨 입니다. 파시겠습니까? 1. 예 2. 아니오 ▼");
			
			int input = sc.nextInt();
			if (input == 1) {
				sellRadish = randomInt;
				break;
			} else if (input == 2) {
				continue;
			}
		}
		
		
		//팔기
		while(true) {
			System.out.println("보유 무 : " + numRadish + "개");
			System.out.println("가진 무를 다 파시겠습니까? 1. 예 2. 아니오 ▼");
			
			int yesNo = sc.nextInt();
			if (yesNo == 1) {
				System.out.println(numRadish + "개의 무를 " + sellRadish + "벨로 팝니다.");
				int rEarn = numRadish * sellRadish;
				System.out.println("총 " + rEarn + "벨을 얻었습니다.");
				System.out.println("-------------------------------");
				System.out.println();
				return rEarn;
			} else if(yesNo == 2) {
				return 0;
			}
		}
		
		
	}
}
