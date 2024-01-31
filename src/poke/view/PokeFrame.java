package poke.view;

import javax.swing.JFrame;
import poke.controller.Controller;

public class PokeFrame extends JFrame 
{
	private Controller controller; 

	public PokeFrame(Controller controller)
	{
		super(); 
		this.controller = controller;
		
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(800, 600);
		this.setTitle("PokeEntry");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
