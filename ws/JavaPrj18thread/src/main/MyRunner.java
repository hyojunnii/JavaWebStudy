package main;

public class MyRunner implements Runnable {

	@Override
	public void run() {
		
		System.out.print(Thread.currentThread().getName() + " : ");
		System.out.println("Runner");
		
	}

}
