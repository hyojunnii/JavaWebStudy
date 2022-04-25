package cafe.employee;

public class CounterEmp {
	
	// 카운터 직원
	
	/* 
	 * 닉네임
	 * 시급 : 9천원
	 * 주문받는 기능
	 * 계산 기능
	 */
	
	public String nick;
	public int money;
	
	public void order() {
		System.out.println("주문받기");
	}
	
	public void calc() {
		System.out.println("계산하기");
	}
}
