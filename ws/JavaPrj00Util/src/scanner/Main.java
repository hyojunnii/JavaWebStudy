package scanner;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 타입지정 nextXXX();
		
//		int i = sc.nextInt();
//		System.out.println(i);
//		
//		long l = sc.nextLong();
//		System.out.println(l);
//		
//		float f = sc.nextFloat();
//		System.out.println(f);
		
		// next : 공백전이나 enter전까지 가져감 
		// nextLine : enter까지 가져감
		
//		String str1 = sc.next();
//		System.out.println(str1);
//		String str2 = sc.next();
//		System.out.println(str2);
//
//		String sl = sc.nextLine();
//		System.out.println(sl);
		
		int x = sc.nextInt();
		String s = sc.nextLine();
		
		System.out.println("x : " + x); // 1 출력
		System.out.println("s : " + s); // enter키 출력
		//실행결과 1 - x:1 s:
				
	}

}
