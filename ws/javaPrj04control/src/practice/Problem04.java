package practice;

import java.util.Scanner;

public class Problem04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

//		if (x == 12 || x == 1 || x == 2) {
//			System.out.println("winter");
//		} else if (x == 3 || x == 4 || x == 5) {
//			System.out.println("spring");
//		} else if (x == 6 || x == 7 || x == 8) {
//			System.out.println("summer");
//		} else {
//			System.out.println("fall");
//		}

		switch (x) {
		case 12:
		case 1:
		case 2:
			System.out.println("winter");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("spring");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("summer");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("fall");
			break;
		default:
			System.out.println("해당 월은 존재하지 않습니다.");
		}
	}

}
