package poke.controller;
import poke.model.*;
import java.util.ArrayList;

public class Controller 
{
	
	String dataFile;
	
	
	//Declare an arrayLIST, not an array, not like int[]
	ArrayList<Pokemon> pokedex;
	
	public Controller()
	{
		//initialize that ho 
		ArrayList<String> pokedex = new ArrayList<String>();
		String dataFile = "";
	}
	
	
	public void start()
	{
		createPokedex();
		
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
