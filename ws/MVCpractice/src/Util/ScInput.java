package Util;

import java.util.Scanner;

public class ScInput {
	
	public static final Scanner sc = new Scanner(System.in);
	
	public static int scInt() {
		int result = sc.nextInt();
		sc.nextLine();
		return result;
	}
	
}//class
