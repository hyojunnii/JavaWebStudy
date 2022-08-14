package util;

import java.util.Scanner;

public class InputUtil {
	
	public static final Scanner sc = new Scanner(System.in);
	
	public static int scanInt() {
		int result = sc.nextInt();
		sc.nextLine();
		return result;
	}
	
	public static double scanDouble() {
		double result = sc.nextDouble();
		sc.nextLine();
		return result;
	}
	
}//class
