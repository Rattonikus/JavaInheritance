package poke.controller;

import poke.model.*;
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
		this.dataFile = "";
		
	}
	
	
	public void start()
	{
		createPokedex();
		this.window = new PokeFrame(this);
			
	}
	
	
	private void createPokedex()
	{
		//10 Pokemon, using 3 constructor types. 
		
		pokedex.add(new Rattata());
		pokedex.add(new Noibat("James"));
		pokedex.add(new Psyduck());
		pokedex.add(new Rattata("Rattie", 20));
		pokedex.add(new Spheal());
		pokedex.add(new Spirigatito());
		pokedex.add(new Spirigatito("Whisker"));
		pokedex.add(new Spheal("Orb"));
		pokedex.add(new Psyduck("Quackens"));
		pokedex.add(new Raticate("bigger rat"));
		
	}
}
