package poke.model.types;

import java.util.List;

import poke.model.Pokemon;

public interface Water 
{
	public abstract Boolean isEffective(Pokemon opponent);
	
	
	public abstract double howEffective(Pokemon opponent);
	
	
	public abstract List<String> getMoves();
	

}
