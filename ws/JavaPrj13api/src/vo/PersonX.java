package vo;

public class PersonX {
	
	//생성자 (모든 필드를 매개변수로 하는)
	// alt + shift + s로 생성자, getter, setter 자동으로 생성 가능
	
	public PersonX(String name, int age, double height, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.gender = gender;
	}

	private String name;
	private int age;
	private double height;
	private char gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void info() {
		// 가지고 있는 모든 데이터 출력해주는 메소드
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("gender : " + gender);
		System.out.println("height : " + height);
	}
	
	//a + sh + s - Generate toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", gender=" + gender + "]";
	}
	
	
}
