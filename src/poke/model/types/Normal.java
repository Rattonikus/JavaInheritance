package poke.model.types;

import java.util.List;

import poke.model.Pokemon;

public interface Normal 
{
	public abstract Boolean isWeak(Pokemon opponent);
	
	
	public abstract double howWeak(Pokemon opponent);
	
	
	public abstract List<String> getMoves();
}
