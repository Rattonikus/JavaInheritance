package poke.model.monster;

import poke.model.Pokemon;
import poke.model.types.Water;

public class Psyduck extends Pokemon implements Water
{
	public Psyduck()
	{
		super(54, "Psyduck");
	}
	
	public Psyduck(String name)
	{
		super(54, name);
	}
	
	public Psyduck(String name, int pokedex)
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
