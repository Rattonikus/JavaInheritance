package poke.model.monster;

import java.util.ArrayList;
import java.util.List;

import poke.model.Pokemon;
import poke.model.types.Water;

public class Psyduck extends Pokemon implements Water
{
	public Psyduck()
	{
		super(54, "Psyduck");
		//setup(true, 50, "Psyduck");
	}
	
	public Psyduck(String name)
	{
		super(54, name);
	}
	
	public Psyduck(String name, int pokedex)
	{
		super(pokedex, name);
	}

	
	public Boolean isEffective(Pokemon opponent) 
	{
		if (opponent instanceof Water)
		{
			return true;
		}
		else
		{
			return false; 
		}

		
	}

	
	public double howEffective(Pokemon opponent)
	{
		if (opponent instanceof Water)
		{
			return 0.5;
		}
		else
		{
			return 0.0;
		}
	}

	
	public List<String> getMoves()
	{
		List<String> psyduckMoves = new ArrayList<>();
		
		psyduckMoves.addAll(List.of(
				"Scratch", "Tail Whip", "Water Gun",
				"Confusion", "Fury Swipes", "Water Pulse",
				"Disable", "Zen Headbutt", "Screetch",
				"Aqua Tail", "Soak", "Psych Up", "Amnesia", "Wonder Room"
				));
		
		return psyduckMoves;
	}
	
	private void setup(boolean canEvolve, int health, String Name)
	{
		this.setCanEvolve(canEvolve);
		this.setHealth(health);
		this.setName(Name);
	}

}
