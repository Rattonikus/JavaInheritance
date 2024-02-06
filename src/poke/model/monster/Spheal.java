package poke.model.monster;

import java.util.ArrayList;
import java.util.List;

import poke.model.Pokemon;
import poke.model.types.Water;

public class Spheal extends Pokemon implements Water
{
	public Spheal()
	{
		super(363, "Spheal");
		//setup(true, 70, "Spheal");
	}
	
	public Spheal(String name)
	{
		super(363, name);
	}
	
	public Spheal(String name, int pokedex)
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
			return 0;
		}
	}

	
	public List<String> getMoves()
	{
		List<String> sphealMoves = new ArrayList<>();
		
		sphealMoves.addAll(List.of(
				"Rollout", "Defense Curl", "Growl",
				"Water Gun", "Powder Snow", "Rest",
				"Snore", "Brine", "Aurora Beam",
				"Encore", "Body Slam", "Surf",
				"Blizzard", "Hail", "Sheer Cold"
				));
		
		return sphealMoves;	
	}
	
	private void setup(boolean canEvolve, int health, String Name)
	{
		this.setCanEvolve(canEvolve);
		this.setHealth(health);
		this.setName(Name);
	}

}
