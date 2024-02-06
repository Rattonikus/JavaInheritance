package poke.model.monster;

import java.util.ArrayList;
import java.util.List;

import poke.model.Pokemon;
import poke.model.types.Flying;
import poke.model.types.Normal;
import poke.model.types.Water;

public class Raticate extends Rattata implements Normal
{
	public Raticate()
	{
		super("Raticate", 20);
		//setup(false, 50, "Raticate");
	}
	
	public Raticate(String name)
	{
		super(name, 20);
	}
	
	public Raticate(String name, int pokedex)
	{
		super(name, pokedex);
	}
	
	public Boolean isWeak(Pokemon opponent) 
	{
		if (opponent instanceof Normal ||
			opponent instanceof Flying ||
			opponent instanceof Water)
		{
			return true; 
		}
		else
		{
			return false;
		}
	}

	
	public double howWeak(Pokemon opponent) 
	{
		if (opponent instanceof Normal ||
				opponent instanceof Flying ||
				opponent instanceof Water)
			{
			return 1.0;
			
			}
		return 0;
	}

	public List<String> getMoves() 
	{
		List<String> rattataMoves = new ArrayList<>();
		
		rattataMoves.addAll(List.of(
				"Tackle", "Tail whip", "Quick attack",
				"Focus Energy", "Bite", "Laser Focus", 
				"Take Down", "Assurance", "Crunch",
				"Sucker punch", "Super Fang", "Double Edge", "Endedavor"
				));
		
		return rattataMoves; 
	}
	
	private void setup(boolean canEvolve, int health, String Name)
	{
		this.setCanEvolve(canEvolve);
		this.setHealth(health);
		this.setName(Name);
	}

}
