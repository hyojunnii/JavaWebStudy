package mob;

public abstract class Pokemon implements PokemonAction {
	//추상클래스 : 객체 생성 불가능, 추상메소드 0개 이상(객체생성 원하지 않으면 추상클래스)
	//추상메소드 : 바디가 없는 메소드, 구현을 강제화
	
	//생성자
	public Pokemon(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}
	
	//필드
	private String name;
	private int hp;
	private int atk;
	
	//메소드
	public void bodyAttack() {
		System.out.println(name + "의 몸통박치기");
	}
	
	//getter, setter
	public String getName() {
		return name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		if(this.hp < hp) {
			this.hp = hp;			
		}
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		if(this.atk < atk) {
			this.atk = atk;	
		}
	}
	
	//toString
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", atk=" + atk + "]";
	}
	
}
