package poke.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import poke.model.monster.*;

public abstract class Pokemon implements Serializable
{
	private int pokedexNumber;
	private int health;
	private boolean canEvolve;
	private String name;
	private ArrayList pokedex; 

	
	public Pokemon(int pokedexNumber, String name)
	{	
		this.pokedexNumber = pokedexNumber;
		this.name = name;
		this.canEvolve = false;
		this.health = 100;
		this.pokedex = new ArrayList<>();
	}

	public String[] getTypes()
	{

		String[] types = null;
		ArrayList<String> implementedTypes = new ArrayList<String>();
		Class<?> currentClass = this.getClass();

		while (currentClass.getSuperclass() != null)
		{
			Class<?>[] pokemonTypes = currentClass.getInterfaces();
			types = new String[pokemonTypes.length];
			for (int index = 0; index < types.length; index++)
			{
				String currentInterface = pokemonTypes[index].getSimpleName();

				if (!implementedTypes.contains(currentInterface) && !currentInterface.contains("Serializable"))
				{
					implementedTypes.add(currentInterface);
				}
			}
			currentClass = currentClass.getSuperclass();
		}
		types = new String[implementedTypes.size()];
		for (int index = 0; index < implementedTypes.size(); index++)
		{
			types[index] = implementedTypes.get(index);
		}

		return types;
	}

	public int getHealth()
	{
		return health;
	}

	public boolean isCanEvolve()
	{
		return canEvolve;
	}

	public String getName()
	{
		return name;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public void setCanEvolve(boolean canEvolve)
	{
		this.canEvolve = canEvolve;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	private void createPokedex()
	{
		pokedex.add(new Noibat());
		pokedex.add(new Psyduck());
		pokedex.add(new Raticate());
		pokedex.add(new Rattata());
		pokedex.add(new Spheal());
		pokedex.add(new Sprigatito());
		
	}
	
	public int getPokedex()
	{
		return pokedexNumber;
	}
	
	@Override
	public String toString()
	{
		String description = "Hi, I am a " +  this.getClass().getSimpleName() + " pokemon my name is: " + getName() + " and my Pokedex number is: " + getPokedex();
		
		return description;
	}
}
