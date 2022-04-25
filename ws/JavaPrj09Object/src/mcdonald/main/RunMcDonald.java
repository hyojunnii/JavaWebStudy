package mcdonald.main;

import mcdonald.emp.CookEmp;
import mcdonald.emp.CounterEmp;
import mcdonald.emp.RiderEmp;

public class RunMcDonald {

	public static void main(String[] args) {

		// 객체 이용해서 프로그래밍 

		System.out.println("====맥도날드====");

		// 객체 미리 만들기
		CounterEmp counter01 = new CounterEmp();
		CookEmp cook01 = new CookEmp();
		RiderEmp rider01 = new RiderEmp();
		
		// 주문 > 요리 > 배달
		String ham = counter01.order();
		counter01.calc();
		cook01.cook(ham);
		rider01.delivery(ham);
		
		
	}

}
