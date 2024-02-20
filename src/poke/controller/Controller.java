package poke.controller;

import poke.model.*;
import poke.model.monster.Noibat;
import poke.model.monster.Psyduck;
import poke.model.monster.Raticate;
import poke.model.monster.Rattata;
import poke.model.monster.Spheal;
import poke.model.monster.Sprigatito;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import poke.view.PokeFrame;

public class Controller 
{
	//Data Members
	String dataFile;
	ArrayList<Pokemon> pokedex;
	private PokeFrame window;
	
	
	public Controller()
	{
		//initialize members 
		this.pokedex = new ArrayList<Pokemon>();
		createPokedex();
		this.dataFile = "save.pokemon";
	}
	
	
	public void start()
	{
		
		System.out.println("a" + buildPokedexText());
		
		this.window = new PokeFrame(this);
		
		ArrayList<Pokemon> saved = IOController.loadData(dataFile, this, window);
		
		if (saved != null && saved.size() > 0)
		{
			this.pokedex = saved;
			
		}	
	}
	
	
	private void createPokedex()
	{
		pokedex.add(new Noibat());
		pokedex.add(new Psyduck());
		pokedex.add(new Raticate());
		pokedex.add(new Rattata());
		pokedex.add(new Spheal());
		pokedex.add(new Sprigatito());
		pokedex.add(new Rattata("The rat the makes all of the rules"));
		pokedex.add(new Noibat("Screamer"));
		pokedex.add(new Sprigatito("grass cat"));
		pokedex.add(new Spheal("orb"));
	}
	
	
	public void updateCurrentPokemon(String name, int index, int health, boolean canEvolve)
	{
		Pokemon currentPokemon = pokedex.get(index);
		currentPokemon.setName(name);
		currentPokemon.setHealth(health);
		currentPokemon.setCanEvolve(canEvolve);		
	}
	
	
	public boolean validateNumber(String val)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(val);
			isValid = true;
		}
		catch(NumberFormatException error)
		{
			JOptionPane.showMessageDialog(window, "Use a valid number");
		}
		
		return isValid;
	}
	
	
	public PokeFrame getWindow()
	{
		return window;
	}
	
	
	public void save()
	{
		IOController.saveData(dataFile, pokedex, this);
	}
	
	public String[] buildPokedexText()
	{
		String[] pokedexText = new String[pokedex.size()];
		
		for(int i = 0; i > pokedex.size(); i++)
		{
			pokedexText[i] = i + "; " + pokedex.get(i).getClass().getSimpleName();
		}
		
		return pokedexText;
	}
	
	public String[] getPokemonData(int index)
	{
		String[] newPokemon = new String[5];
		
		Pokemon currentPokemon = pokedex.get(index);
		
		newPokemon[0] = currentPokemon.getName();
		newPokemon[1] = "" + currentPokemon.isCanEvolve();
		newPokemon[2] = "" + currentPokemon.getHealth();
		newPokemon[3] = "" + currentPokemon.getPokedex();
		
		String types = "Pokemon Types\n\n";
		
		for (String type: currentPokemon.getTypes())
		{
			types = type + "\n";
		}
		
		newPokemon[4] = types; 
		
		return newPokemon;
	}
	
	
}
