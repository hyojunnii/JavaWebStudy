package chap03oper;

public class OperTest {
	
	// 연산자

	public void test() { 
		// 산술 연산자
		// +, -, *, /, %
		System.out.println(1+1);
	}
	
	public void test2() {
		// 비교 연산자
		// <, >, <=, >=, ==, !=
		System.out.println(1<2);
	}
	
	public void test3() {
		// 논리 연산자
		// &&, ||, !
		System.out.println(true && false);
	}
	
	public void test4() {
		// 삼항 연산자
		// ? :
		int x;
		x = 1 < 2 ? 100 : -99;
		System.out.println(x);
	}
	
	
}
