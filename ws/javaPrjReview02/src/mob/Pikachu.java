package mob;

public class Pikachu extends Pokemon {
	
	private static final String name = "피카츄";
	
	public Pikachu(int hp, int atk) {
		super(name, hp, atk);
	}

	@Override
	public void skill() {
		System.out.println("백만볼트");
	}
	
	
	
}
