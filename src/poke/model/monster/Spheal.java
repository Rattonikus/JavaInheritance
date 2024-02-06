package poke.model.monster;

import poke.model.Pokemon;
import poke.model.types.Water;

public class Spheal extends Pokemon implements Water
{
	public Spheal()
	{
		super(363, "Spheal");
	}
	
	public Spheal(String name)
	{
		super(363, name);
	}
	
	public Spheal(String name, int pokedex)
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
