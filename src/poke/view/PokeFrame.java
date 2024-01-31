package poke.view;

import javax.swing.JFrame;
import poke.controller.Controller;

public class PokeFrame extends JFrame 
{
	private Controller controller; 
	
	private PokePanel panel;

	public PokeFrame(Controller controller)
	{
		super(); 
		this.controller = controller;
		this.panel = new PokePanel(controller);
		
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setSize(800, 600);
		this.setTitle("PokeEntry");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
