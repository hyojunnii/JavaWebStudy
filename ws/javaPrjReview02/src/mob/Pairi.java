package mob;

public class Pairi extends Pokemon {

	private static final String name = "파이리";
	
	public Pairi(int hp, int atk) {
		super(name, hp, atk);
	}
	
	@Override
	public void skill() {
		System.out.println("파이어볼");
	}

}
