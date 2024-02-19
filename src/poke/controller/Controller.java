package poke.controller;

import poke.model.*;
import poke.model.monster.Noibat;
import poke.model.monster.Psyduck;
import poke.model.monster.Raticate;
import poke.model.monster.Rattata;
import poke.model.monster.Spheal;
import poke.model.monster.Sprigatito;
import poke.model.types.*;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import poke.view.PokeFrame;

public class Controller 
{
	
	String dataFile;
	//Declare an arrayLIST, not an array, not like int[]
	ArrayList<Pokemon> pokedex;
	private PokeFrame window; 
	
	public Controller()
	{
		//initialize that ho 
		this.pokedex = new ArrayList<Pokemon>();
		createPokedex();
		this.dataFile = "src/poke/model/Pokemon.java";
		
	}
	
	
	public void start()
	{
		//createPokedex();
		//this.window = new PokeFrame(this);
		
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
	
	
}
