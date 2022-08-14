package main;


import mob.Kkobuki;
import mob.Pairi;
import mob.Pikachu;
import mob.Pokemon;
import person.Trainer;

public class PokemonMain {

	public static void main(String[] args) {

		System.out.println("=====포켓몬=====");
		
		Pokemon p1 = new Pikachu(100, 30);
		Pokemon p2 = new Pairi(100,25);
		Pokemon p3 = new Kkobuki(100,20);
		Pokemon[] pArr = new Pokemon[3];
		pArr[0] = p1;
		pArr[1] = p2;
		pArr[2] = p3;

		Trainer t = new Trainer("심원용");
		t.addPokemon(p1);
		t.addPokemon(p2);
		t.addPokemon(p3);
		
		System.out.println(t.getPokemon("피카츄"));
		
		t.printAllPokemonName();
		
	}

}
