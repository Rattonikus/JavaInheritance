package poke.model;

public class Rattata extends Pokemon
{
	public Rattata()
	{
		super(19, "Rattata");
	}
	
	//Overloaded constructor; Lets us name individual pokemon
	public Rattata(String name)
	{
		super(19, name);
	}
	
	//Another overloaded constructor; This time it supports evolution of pokemon
	public Rattata(String name, int pokedex)
	{
		super(pokedex, name);
	}

}
