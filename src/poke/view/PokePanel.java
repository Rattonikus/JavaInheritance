package poke.view;
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.color.*;
import java.awt.GridLayout;
import poke.controller.Controller;
import poke.model.Pokemon;
import poke.controller.*;
import java.util.ArrayList;



public class PokePanel extends JPanel
{
	
	private Controller app; 
	private SpringLayout layout;
	
	private JPanel fieldPanel;
	private JTextField nameField;
	private JTextField healthField;
	private JTextField numberField;
	private JTextArea typeArea;
	private JCheckBox evolveBox;
	
	private JLabel imageLabel;
	private ImageIcon pokemonImage;
	private JComboBox<String> pokedexSelector;
	
	private JLabel healthLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;

	private JScrollPane typesPane;
	
	private JButton updateButton; 
	private JButton saveButton;
	
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
		this.imageLabel = new JLabel("image");
		this.pokemonImage = new ImageIcon();
		this.pokedexSelector = new JComboBox<String>();
		
		this.updateButton = new JButton(); 
		this.saveButton = new JButton("Save");
		
		setupDropDown();
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		this.setBackground(Color.lightGray);
		this.setPreferredSize(new Dimension(1024, 768));
		
		this.typesPane.setViewportView(typeArea);
		this.typesPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		this.typesPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.fieldPanel.add(healthLabel);
		this.fieldPanel.add(healthField);
		
		this.fieldPanel.add(nameLabel);
		this.fieldPanel.add(nameField);
		
		this.fieldPanel.add(numberLabel);
		this.fieldPanel.add(numberField);
		this.numberField.setEditable(false);
		
		this.fieldPanel.add(evolveBox);
		this.fieldPanel.add(typesPane);
		this.typeArea.setEditable(false);
		 	
		this.fieldPanel.add(updateButton);
		this.fieldPanel.add(saveButton);
		
		this.add(fieldPanel);
		this.add(imageLabel);
		this.add(pokedexSelector);
		
		
		
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	private void setupListeners()
	{
		updateButton.addActionListener(click -> collectInput());
		saveButton.addActionListener(click -> app.save());
		pokedexSelector.addActionListener(click -> updatePokemonScreen());
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
			pokemonImage = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch(NullPointerException missingFile)
		{
			pokemonImage = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		
		imageLabel.setIcon(pokemonImage);
		repaint();
	}
	
	private void collectInput()
	{
		String name = nameField.getText();
		String health = healthField.getText();
		boolean canEvolve = evolveBox.isSelected();
		int selectedPokemon = pokedexSelector.getSelectedIndex();
		
		if(app.validateNumber(health))
		{
			int healthValue = Integer.parseInt(health);
			
			app.updateCurrentPokemon(name, selectedPokemon, healthValue, canEvolve);
		}
	}
	
	private void setupDropDown()
	{
		DefaultComboBoxModel<String> drop = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexSelector.setModel(drop);
	}
	
	private void updateFields(int index)
	{
		String[] field = app.getPokemonData(index);
		
		nameField.setText(field[0]);
		
		evolveBox.setSelected(Boolean.parseBoolean(field[1]));
		healthField.setText(field[2]);
		numberField.setText(field[3]);
		typeArea.setText(field[4]);
	}
	
	private void updatePokemonScreen()
	{
		String name = pokedexSelector.getSelectedItem().toString();
		
		int whereName = name.indexOf("; ") + 2;
		
		name = name.substring(whereName);
		
		imageLabel.setText(name);
		updateDisplay(name);
		updateFields(pokedexSelector.getSelectedIndex());
		
	}

}
