package practice;

public class MyClass01 {
	
	//객체 생성, 메소드 호출
	
	public String name; //전역변수 class변수 Heap
	public int age;
	
	/*
	 * 지역변수 vs 필드(인스턴스변수==전역변수==클래스변수==멤버변수)
	 * - 서로 같은 이름 사용 가능
	 * - 메소드 안에서는 지역변수가 선택된다
	 * - this.변수명 으로 써주면 필드가 선택된다
	 */
	
	public void introduce() {
		String name = "지역변수 생성";
		name = "지역변수";
		this.name = "메소드 안에서 만든 이름";
		//this : 현재 객체 데이터 = public String name
		System.out.println("안녕 나는 MyClass01 타입이야");
		System.out.println("내 이름은 " + name);
		System.out.println("내 나이는 " + age);
	}
	
	public void myMethod01() {
		System.out.println("MyClass01 의 myMethod01 호출");
	}
	public void myMethod02() {
		System.out.println("MyClass01 의 myMethod02 호출");
	}
	
	
}
