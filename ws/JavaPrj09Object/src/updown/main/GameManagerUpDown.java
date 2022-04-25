package updown.main;

import java.util.Random;
import java.util.Scanner;

public class GameManagerUpDown {

	public final String gameName = "업다운";

	public void gameStart() {
		System.out.println(gameName + " 게임시작");

		int r = new Random().nextInt(50);
		
		//Random randomObject = new Random();
		//int r = randomObject.nextInt(50);

		Scanner sc = new Scanner(System.in);

		while (true) {
			int user = sc.nextInt();
			if (user > r) {
				System.out.println("down");
			} else if (user < r) {
				System.out.println("up");
			} else {
				System.out.println("정답입니다.");
				break;
			}
		}
	}

}
