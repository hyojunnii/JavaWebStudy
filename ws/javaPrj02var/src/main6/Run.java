package main6;

public class Run {

	public static void main(String[] args) {

		int i;
		byte b = 1;
		
		i = b; // 묵시적 형변환
		i = (int) b; // 명시적 형변환
		
		System.out.println(i);
	}

}
