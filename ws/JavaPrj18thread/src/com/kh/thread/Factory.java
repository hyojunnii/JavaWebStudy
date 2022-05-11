package com.kh.thread;

public class Factory {
	
			//실행되면 객체에 락을 검 -> 다른 메소드가 접근 불가(Block)
	public synchronized void methodA() {
		System.out.println("A called...");
		//깨우고
		notify();
		//대기열로
		try {
			wait(500);
//			Thread.sleep(500); //sleep은 notify로 못깨움
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	public synchronized void methodB() {
		System.out.println("B called...");
		notify();
		try {
			wait(500);
//			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

}
