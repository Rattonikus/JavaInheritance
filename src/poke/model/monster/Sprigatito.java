package poke.model.monster;

import java.util.ArrayList;
import java.util.List;

import poke.model.Pokemon;
import poke.model.types.*;

public class Sprigatito extends Pokemon implements Grass
{
	public Sprigatito()
	{
		super(906, "Spirigatito");
		setup(true, 40, "Sprigatito");
	}
	
	public Sprigatito(String name)
	{
		super(906, name);
	}
	
	public Sprigatito(String name, int pokedex)
	{
		super(pokedex, name);
	}

	
	public Boolean isEffective(Pokemon opponent)
	{
		if (opponent instanceof Water || opponent instanceof Grass)
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
		if (opponent instanceof Water || opponent instanceof Grass)
		{
			return 0.5;
		}
		else
		{
			return 0;
		}
	}

	
	public List<String> getMoves()
	{
		List<String> sprigatitoMoves = new ArrayList<>();
		
		sprigatitoMoves.addAll(List.of(
				"Scratch", "Tail Whip", "Leafage",
				"Bite", "Hone Claws", "Magical Leaf",
				"Quick Attack", "Seed Bomb", "U-Turn",
				"Worry Seed", "Slash", "Energy Ball", "Play Rough"
				));
		
		return sprigatitoMoves;
	}

	private void setup(boolean canEvolve, int health, String Name)
	{
		this.setCanEvolve(canEvolve);
		this.setHealth(health);
		this.setName(Name);
		
	}
}
