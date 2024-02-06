package poke.model.monster;

import java.util.ArrayList;
import java.util.List;

import poke.model.Pokemon;
import poke.model.types.*;

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
		if (opponent instanceof Water)
		{
			return 0.5;
		}
		else if (opponent instanceof Grass)
		{
			return 0.25;
		}
		else
		{
			return 0.0;
		}
	}


	public List<String> getMoves()
	{
		List<String> noibatMoves = new ArrayList<>();
		
		noibatMoves.addAll(List.of(
				"Tackle", "Absorb", "Gust",
				"Supersonic", "Double Team", "Wing Attack",
				"Bite", "Aircutter", "Whirwind",
				"Super Fang", "Air Slash", "Screetch",
				"Roost", "Tailwind", "Hurricane"
				));
		
		
		return noibatMoves;
	}

}
