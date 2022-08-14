package main;

public class Main {

	public static void main(String[] args) {
		System.out.println("=====쓰레드=====");
		
		for (int i = 0; i < 10; i++) {
			String name = Thread.currentThread().getName();
			System.out.println(name + ":" + i);
		}
		
		//Thread
		//람다식으로 할일 전달
		Thread t1 = new Thread(() -> {
			String name = Thread.currentThread().getName();
			System.out.println(name + ": 람다식으로 할일 전달");
		});		
		
		//객체로 할일 전달
		Thread t2 = new Thread(new Person());
		
		//익명함수로 객체 생성하여 전달
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println(name + ": 익명클래스로 run 작성");
			}
		});
		
		t1.start(); //main
		t2.start();
		t3.start();
		
		//t1.run(); //thread
		//t2.run();
		//t3.run();
	}
	
	
	
		

}
