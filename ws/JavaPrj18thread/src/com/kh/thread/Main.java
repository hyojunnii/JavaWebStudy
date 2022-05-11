package com.kh.thread;

public class Main {
	
	public static final Factory factory = new Factory();

	public static void main(String[] args) {

		System.out.println("===== 쓰레드 테스트 =====");
		
		/*
		 * start, run
		 * sleep : 일정 시간 wait
		 * wait : sleep과 비슷 (동기화 관련 차이)
		 * interrupt : 방해해서 wait 상태일 때 예외 던지게 함
		 * notify || notiftAll : 대기열 깨우는 명령 sleep,wait -> execute
		 * state : 쓰레드의 상태 (생성,실행,대기,종료)
		 * join : 다른 쓰레드 기다려줌
		 * yield : 다른 쓰레드에게 자원 쓸 수 있게 양보
		 * daemon : 상위 쓰레드에 종속됨(부모 종료시 같이 종료), 처음부터 데몬이어야
		 * group pool priority 등..
		 */

		//sleep
//		for(int i = 10; i > 0; i--) {
//			System.out.println(i);
//			//현 쓰레드 불러와서 1초 sleep 요청
//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				System.out.println("예외 :: " + e.getMessage());
//			}
//		}
//		System.out.println("땡!");
		
//		test1();
		test2();
		
	}//main
	
	private static void test1() {
		
		System.out.println("===== inturrupt test =====");
		
		//MyRunner 이용해서 쓰레드 생성
		Thread t1 = new Thread(new MyRunner());
		t1.start();
		
		t1.interrupt();
	}
	
	private static void test2() {
		
		System.out.println("===== notify test =====");
	
		Thread t1 = new Thread(new RunnerMethodA());
		Thread t2 = new Thread(new RunnerMethodB());
		
		t1.start();
		t2.start();
	}
	
}//class





