package poke.view;
import javax.swing.*;

import java.awt.Color;
import java.awt.color.*;
import poke.controller.Controller;

public class PokePanel extends JPanel
{
	
	private Controller app; 
	
	public PokePanel(Controller app)
	{
		super();
		this.app = app;
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
	}
	private void setupListeners()
	{
		
	}
	private void setupLayout()
	{
	
	}

}
