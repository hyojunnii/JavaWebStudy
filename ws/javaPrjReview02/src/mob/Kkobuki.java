package mob;

public class Kkobuki extends Pokemon {

	private static final String name = "꼬부기";
	
	public Kkobuki(int hp, int atk) {
		super(name, hp, atk);
	}

	@Override
	public void skill() {
		System.out.println("물대포");
	}

	
	
}
