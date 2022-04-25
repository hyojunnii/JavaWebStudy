package chap04if;

import java.util.Scanner;

public class IfTest {

	// 조건문
	
	public void test() {
		int x = -1;
		
		if(x > 0) {
			System.out.println("양수");
		} else if(x < 0) {
			System.out.println("음수");
		} else {
			System.out.println("zero");
		}
	}
	
	public void test2() {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		switch(x) {
		case 12 : 
		case 1 : 
		case 2 : System.out.println("winter");	break;
		
		case 3 : 
		case 4 :
		case 5 : System.out.println("spring"); break;
		
		case 6 :
		case 7 :
		case 8 : System.out.println("summer"); break;
		
		case 9 :
		case 10 :
		case 11 : System.out.println("fall"); break;
		
		default : System.out.println("1~12");
		}
	}
		
}
