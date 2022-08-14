package main;

public class Person implements Runnable{

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + ": 객체로 할일 전달");
	}
	
}
