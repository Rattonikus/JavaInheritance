package poke.model.monster;

import poke.model.Pokemon;
import poke.model.types.*;

public class Rattata extends Pokemon implements Normal
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

	
	public Boolean isEffective() 
	{
		return null;
	}

	
	public int howEffective() 
	{
		return 0;
	}

	public String getMoves() 
	{
		return null;
	}

}
