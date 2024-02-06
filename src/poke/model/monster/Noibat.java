package poke.model.monster;

import poke.model.Pokemon;
import poke.model.types.Flying;

public class Noibat extends Pokemon implements Flying
{
	public Noibat()
	{
		super(714, "Noibat");
	}
	
	public Noibat(String name)
	{
		super(714, name);
	}
	
	public Noibat(String name, int pokedex)
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
