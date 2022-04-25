package cafe.main;

import cafe.employee.CounterEmp;
import cafe.employee.KitchenEmp;

public class Run {

	public static void main(String[] args) {
		
		System.out.println("--cafe open--");
		
		CounterEmp ce = new CounterEmp();
		KitchenEmp ke = new KitchenEmp();
		
		ce.order();
		ce.calc();
		ke.cook();
		ke.complete();
		
		ce.nick = "심원용";
		ke.nick = "심투용";
		
		System.out.println("카운터직원 : " + ce.nick);
		System.out.println("주방직원 : " + ke.nick);
		
	}

}
