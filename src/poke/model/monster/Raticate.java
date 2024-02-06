package poke.model.monster;

import poke.model.Pokemon;
import poke.model.types.Normal;

public class Raticate extends Rattata implements Normal
{
	public Raticate()
	{
		super("Raticate", 20);
	}
	
	public Raticate(String name)
	{
		super(name, 20);
	}
	
	public Raticate(String name, int pokedex)
	{
		super(name, pokedex);
	}

}
