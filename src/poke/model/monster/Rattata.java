package poke.model.monster;

import java.util.ArrayList;
import java.util.List;

import poke.model.Pokemon;
import poke.model.types.*;

public class Rattata extends Pokemon implements Normal
{
	private static final long serialVersionUID = 1L;

	public Rattata()
	{
		super(19, "Rattata");
		setup(true, 30, "Rattata");
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
