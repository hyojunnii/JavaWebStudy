package main;

public class Main {
											
	public static void main(String[] args) {

		System.out.println("===== 예외 처리 =====");
		
		//예외 : 너무 크리티컬 하지 않은 에러
		
		/*
		 * <에러>
		 * 컴파일 런타임 시스템
		 * 
		 * <처리>
		 * 1. try-catch : 처리
		 * 2. throw : 남한테 미룸, 여러번 가능
		 */
		
		// 예외 받아서 처리
		Test t = new Test();
		try {
			t.methodA();
		} catch (Exception e) {
//			e.printStackTrace(); //빨간 글씨로 에러메세지 출력
			System.out.println("메인 메소드에서 Exception catch");
			if(e instanceof MyException) {
				System.out.println("방금 잡은 예외는 MyException 타입");
			}
		}
		//Main에서 예외 다시 던지면 : 프로그램 종료
		
		
		// 내가 만든 예외 처리
//		try {
//			throw new MyException();
//		} catch (Exception e){
//			System.out.println("내가 만든 에러 잡음");
//		}
		
		
		// 예외 처리
//		System.out.println("안녕");
//		
//		try {
//			String str = null;
//			String strSub = str.substring(2,5);
//			System.out.println(strSub);
//			int x = 1 / 0;
//		} catch(ArithmeticException e) {
//			System.out.println("AE 잡음");
//		} catch(Exception e) {
//			System.out.println("예외 잡았음");
//		}
//		
////		catch(NullPointerException e) {
////			System.out.println("NPE 잡았음");
////		}
//		
//		System.out.println("바이");
		
	}//main

}
