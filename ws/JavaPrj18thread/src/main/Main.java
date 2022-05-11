package main;

public class Main {

	public static void main(String[] args) {

		//Thread
		/*
		 * 생성방법 3가지
		 * 1.extends Thread
		 * 2.implements Runnable
		 * 3.lambda
		 * 
		 * 시작방법 : start()
		 * 실행 : run()을 실행
		 * run()을 가진 class/interface를 상속 받아야 사용가능
		 */
		
		String name = Thread.currentThread().getName();
		System.out.print(name + " : ");
		
		System.out.println("===== 쓰레드 =====");
		
		// extends Thread : 객체 활용하여 쓰레드 생성
		Thread t1 = new MyThread();
		t1.start();
		
		// implements Runnable : 객체 활용하여 쓰레드 생성 - 다중상속 때문에 많이 사용됨
		Thread t2 = new Thread(new MyRunner());
		t2.start();
		
		// 람다식 활용하여 쓰레드 생성 - implements 객체 파일 만들지 않고 사용가능
		Thread t3 = new Thread(
							() -> {
								System.out.print(Thread.currentThread().getName() + " : ");
								System.out.println("람다식");
							});
		t3.start();
	}

}//class
