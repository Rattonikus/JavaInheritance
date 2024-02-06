package poke.model.monster;

import poke.model.Pokemon;

public class Spirigatito extends Pokemon implements Grass
{
	public Spirigatito()
	{
		super(906, "Spirigatito");
	}
	
	public Spirigatito(String name)
	{
		super(906, name);
	}
	
	public Spirigatito(String name, int pokedex)
	{
		super(pokedex, name);
	}

}
