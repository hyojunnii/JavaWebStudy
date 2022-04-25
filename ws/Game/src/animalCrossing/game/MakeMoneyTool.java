package animalCrossing.game;

import java.util.Scanner;

public class MakeMoneyTool {

	public void moneyTool() {
		
		Scanner sc = new Scanner(System.in);
		
		MakeMoney makeMoney = new MakeMoney();
		
		//돈 벌기
		System.out.println("-------------------------------");
		System.out.println("돈을 벌어보자!");
		System.out.println("1. 과일팔기 2. 무주식하기(미구현) ▼");
		
		//do
		int c = sc.nextInt();
		if(c == 1) {
			makeMoney.sellFruit();
		} else if (c == 2) {
			makeMoney.radishStock();
		} else {
			System.out.println("다시 입력해줘!");
		}
		
	}
	
}
