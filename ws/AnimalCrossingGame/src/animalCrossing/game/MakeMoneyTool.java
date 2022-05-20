package animalCrossing.game;

import java.util.Scanner;

public class MakeMoneyTool {

	public static int totalMoney;
	
	public void moneyTool() {
		
		Scanner sc = new Scanner(System.in);
		
		MakeMoney makeMoney = new MakeMoney();
		
		//돈 벌기
		System.out.println("-------------------------------");
		System.out.println("돈을 벌어보자!");
		System.out.println("1. 과일팔기 2. 무주식하기 ▼");
		
		//do
		int c = sc.nextInt();
		if(c == 1) {
			makeMoney.sellFruit();
			System.out.println("현재 잔액은 " + totalMoney + "벨 입니다.");
			System.out.println("게임을 그만두었습니다.");
		} else if (c == 2) {
			totalMoney = totalMoney + makeMoney.radishStock();
			System.out.println("현재 잔액은 " + totalMoney + "벨 입니다.");
			System.out.println("게임을 그만두었습니다.");
		} else {
			System.out.println("다시 입력해줘!");
		}
		
	}
	
}
