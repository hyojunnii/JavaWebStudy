package main;

public class Test {

						//예외 던지기
	public void test() throws Exception {
		
		//예외 직접 발생시키기
		
		//직접 처리
//		try {
//			throw new Exception(); //Exception 객체를 던짐
//		} catch(Exception e) {
//			System.out.println("예외 잡음");
//		}
		
		//Throwable타입의 객체(예외)를 던질 수 있음
		throw new Exception();
		
	}
	
	public void methodA() throws Exception {
		System.out.println("메소드 A 호출");
		try {
			methodB();
		} catch (Exception e) {
			throw new MyException();
		}
//		int x = 10;
//		if(x > 0) {
//			throw new MyException;
//		}
//		try {
//			methodB();
//		} catch(Exception e) {
//			throw new MyException();
//		}
		System.out.println("메소드 A 종료");
	}
	
	public void methodB() throws Exception {
		System.out.println("메소드 B 호출");
		methodC();
		System.out.println("메소드 B 종료");
	}
	
	public void methodC() throws Exception {
		System.out.println("메소드 C 호출");
//		throw new Exception(); //예외 발생시킴
		int x = 1 / 0;
		System.out.println("메소드 C 종료");
	}
	
}//class
