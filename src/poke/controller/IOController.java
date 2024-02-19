package poke.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import poke.model.monster.*;
import poke.view.PokeFrame;
import poke.model.*;

public class IOController 
{
	public static ArrayList<Pokemon> loadData(String dataFile, Controller app, PokeFrame frame)
	{
		ArrayList<Pokemon> savedPokemonList = null;
		
		try(FileInputStream loadStream = new FileInputStream(dataFile);
				ObjectInputStream input = new ObjectInputStream(loadStream))
		{
			ArrayList<Pokemon> loadedPokemon = new ArrayList<Pokemon>();
			loadedPokemon = (ArrayList<Pokemon>) input.readObject();
			savedPokemonList = loadedPokemon;
		}
		catch(IOException readError)
		{
			JOptionPane.showMessageDialog(app.getWindow(), readError.getMessage(), "Could not read file", JOptionPane.ERROR_MESSAGE);
		}
		catch(ClassNotFoundException classError)
		{
			JOptionPane.showMessageDialog(app.getWindow(), classError.getMessage(), "Class error", JOptionPane.ERROR_MESSAGE);
		}
		
		return savedPokemonList;
	}
	
	public static void saveData(String dataFile, ArrayList<Pokemon> pokemonList, Controller app)
	{	
		try(FileOutputStream saveStream = new FileOutputStream(dataFile);
			ObjectOutputStream output = new ObjectOutputStream(saveStream))
		{
			output.writeObject(pokemonList);
		}
		catch(IOException saveError)
		{
			JOptionPane.showMessageDialog(app.getWindow(), saveError.getMessage(), "Couldnt save", JOptionPane.ERROR_MESSAGE);
		}
			}
	

}
