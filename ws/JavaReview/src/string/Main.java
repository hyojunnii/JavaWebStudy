package string;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String str = "Hello: World!";
		System.out.println(str.charAt(4));
		System.out.println(str.substring(1,5));
		System.out.println(str.equals("hello"));
		//"hello".equals(str) 이 더 좋은 코드 -> str이 null일 수도 있어서 literal과 비교하는게 낫다
		System.out.println(str.contains("abc"));
		System.out.println(str.indexOf("r"));
		String[] s = str.split(":");
		System.out.println(Arrays.toString(s));
	}

}
