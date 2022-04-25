package chap02var;

public class VarTest {

	public void test() {
		int x = 10;
		System.out.println(x);
	}
	
	public void test2() {
		// 정수형 변수
		byte b = 127;	// 1byte
		short s = 1;	// 2byte
		int i = 10;		// 4byte
		long l = 999;	// 8byte
		
		System.out.println("byte b : " + b);
		System.out.println("short s : " + s);
		System.out.println("int i : " + i);
		System.out.println("long l : " + l);
	}
	
	public void test3() {
		// 실수형 변수
		float f = 3.14f;	// 4byte
		double d = 3.1427;	// 8byte
		
		System.out.println("float f : " + f);
		System.out.println("double d : " + d);
	}
	
	public void test4() {
		// 논리형 변수
		boolean b = true;	// 1byte
		System.out.println("boolean b : " + b);
		
		// 문자형 변수
		char ch = 'A';		// 2byte
		System.out.println("char ch : " + ch); 
	}
	
	public void test5() {
		// 문자열
		String str = "hi";
		System.out.println("String str : " + str);
	}
	
	public void test6() {
		
		final double PI =  3.14; // 상수(final)
//		pi = 3.41;	// 값 다시 할당 불가
	}
	
}
