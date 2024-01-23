package poke.model;

public class Psyduck extends Pokemon
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

}
