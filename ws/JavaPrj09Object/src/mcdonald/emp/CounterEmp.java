package mcdonald.emp;

import java.util.Scanner;

public class CounterEmp {

	Scanner sc = new Scanner(System.in);

	String name;
	int money;
	
	public String order() {
		System.out.println("주문 받을게요");
		//입력받기
		String ham = this.sc.nextLine();
		
		System.out.println(ham + " 주문 받았습니다~");
		return ham;
	}
	
	public void calc() {
		System.out.println("계산할게요");
		//돈 받기
		String price = this.sc.nextLine();
		
		System.out.println(price + "원 받았습니다~");
	}
	
}
