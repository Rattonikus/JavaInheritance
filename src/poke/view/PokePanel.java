package poke.view;
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.color.*;
import java.awt.GridLayout;
import poke.controller.Controller;

public class PokePanel extends JPanel
{
	
	private Controller app; 
	private SpringLayout layout;
	
	private JPanel fieldPanel;
	
	private JTextField nameField;
	private JTextField numberField;
	private JTextField healthField;
	private JLabel healthLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;


	
	private JCheckBox evolveBox;
	private JTextArea typeArea;
	private JScrollPane typesPane;
	
	
	private JLabel imageLabel;
	private ImageIcon icon;
	private JComboBox<String> pokedexSelector;

	
	
	public PokePanel(Controller app)
	{
		super();
		this.app = app;
		this.layout = new SpringLayout();
		
		this.fieldPanel = new JPanel(new GridLayout(0,2));		
		
		this.nameField = new JTextField("Name");
		this.numberField = new JTextField("Number");
		this.healthField = new JTextField("Health");
		
		this.nameLabel = new JLabel("Pokemon Name: ");
		this.numberLabel = new JLabel("Pokemon Number: ");
		this.healthLabel = new JLabel("Pokemon Health: ");
		
		
		this.evolveBox = new JCheckBox("Can evolve?", false);
		
		this.typeArea = new JTextArea(20, 20);
		this.typesPane = new JScrollPane();
		this.imageLabel = new JLabel("Image");
		this.icon = new ImageIcon();
		this.pokedexSelector = new JComboBox<String>();

		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		this.setBackground(Color.lightGray);
		this.setPreferredSize(new Dimension(800, 600));
		
		this.numberField.setEnabled(false);
		this.typeArea.setEnabled(false);
		this.typesPane.setViewportView(typeArea);
		this.typesPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.typesPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.fieldPanel.add(healthLabel);
		this.fieldPanel.add(healthField);
		
		this.fieldPanel.add(nameLabel);
		this.fieldPanel.add(nameField);
		
		this.fieldPanel.add(numberLabel);
		this.fieldPanel.add(numberField);
		
		this.fieldPanel.add(evolveBox);
		this.fieldPanel.add(typesPane);
		
		this.add(fieldPanel);
		this.add(imageLabel);
		this.add(pokedexSelector);
		
		updateDisplay("");
		
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	private void setupListeners()
	{
		
	}
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.WEST, fieldPanel, -350, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.EAST, fieldPanel, -25, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, fieldPanel, 25, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, fieldPanel, -25, SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, imageLabel, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, imageLabel, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, imageLabel, -100, SpringLayout.WEST, fieldPanel);
		
		layout.putConstraint(SpringLayout.WEST, pokedexSelector, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, pokedexSelector, -150, SpringLayout.WEST, fieldPanel);
		layout.putConstraint(SpringLayout.SOUTH, pokedexSelector, -200, SpringLayout.SOUTH, this);
	}
	
	private void updateDisplay(String param)
	{
		String path = "/poke/view/images/";
		String name = param;
		String defaultName = "Rattata";
		String extension = ".png";
		
		try
		{
			icon = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch(NullPointerException missingFile)
		{
			icon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		
		imageLabel.setIcon(icon);
		repaint();
	}

}
