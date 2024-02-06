package poke.model.types;

import java.util.List;

import poke.model.Pokemon;

public interface Grass
{
	public abstract Boolean isEffective(Pokemon opponent);
	
	
	public abstract double howEffective(Pokemon opponent);
	
	
	public abstract List<String> getMoves();

}
