package javapaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import listeners.ClearListener;
import listeners.MouseDetectorListener;
import listeners.SaveListener;

public @SuppressWarnings("serial")
class JavaPaintGui extends JFrame{
	
	private static String[] defaultAvailableUtensils = {"Oval", "Rectangle", "Eraser"};
	//The default available utensils
	//A list of the stuff that's implemented so far
	//Only used in parameterless constructor
	
	private JButton saveButton = null;
	//JButton that opens save dialog

	private CanvasPanel canvasPanel = null;
	//The panel that is drawn upon

	private MouseDetectorListener mouser = null;
	//The mouse listener (listens for clicks and drags)

	private String[] availableUtensils = null;
	//Array of available utensils
	//Used to populate utensilSelector

	private JComboBox<String> utensilSelector = null;
	//Combo Box to select utensil
	//Populated by availibleUtensils

	private JButton resetButton = null;
	//Button to clear PaintPanel (Empties the ArrayList)

	private JColorChooser colorChooser = null;
	//Color selector for utensil
	
	JavaPaintGui(){
		//Parameter-less constructor
		//Calls primary constructor with default parameters
		
		this(defaultAvailableUtensils);
	}

	JavaPaintGui(String[] availibleUtensils){
		//Primary constructor
		//Parameter specifies what to populate UtensilSelector with
		
		super("JavaPaint");
		//Title the window

		this.availableUtensils = availibleUtensils;

		canvasPanel = new CanvasPanel();
		//Instantiate a CanvasPanel
		//Container for BufferedCanvas
		
		utensilSelector = new JComboBox<String>(availableUtensils);
		//Listen to utensilSelector

		canvasPanel.setPreferredSize(new Dimension(500, 500));

		mouser = new MouseDetectorListener(this);
		//Create a new MouseDetectorListener

		canvasPanel.addMouseListener(mouser);
		canvasPanel.addMouseMotionListener(mouser);
		//Add listener for click (MouseListener) and drag (MouseMotionListener)

		canvasPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//Draw a border around the drawing area
		
		utensilSelector = new JComboBox<String>(availableUtensils);
		//Create a JComboBox to pick utensils

		resetButton = new JButton("Clear");
		//Add a reset button that says Clear

		resetButton.addActionListener(new ClearListener(canvasPanel));
		//Listen to the clear button

		colorChooser = new JColorChooser(Color.black);
		//Initialize the color chooser on black

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveListener(this, canvasPanel.getBufferedCanvas()));

		addComponents();
		pack();
		setVisible(true);
	}
	
	public String getSelectedUtensil(){
		//Get currently selected element from utensilSelector
		return (String) utensilSelector.getSelectedItem();
	}
	
	public Color getSelectedColor(){
		//Get currently selected color from the color selector
		return colorChooser.getColor();
	}
	
	public CanvasPanel getCanvasPanel(){
		//Get a reference to the canvasPanel
		return canvasPanel;
	}

	private void addComponents(){
		//Add all of the components :)
		//Note the use of getContentPane()

		getContentPane().add(canvasPanel);
		getContentPane().add(utensilSelector);
		getContentPane().add(resetButton);
		getContentPane().add(saveButton);
		getContentPane().add(colorChooser);
	}
}
