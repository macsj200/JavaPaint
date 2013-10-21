package javapaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import utensils.AvailableUtensils;
import utensils.UtensilFactory;

import listeners.ClearListener;
import listeners.ColorPickerListener;
import listeners.MouseDetectorListener;
import listeners.SaveListener;
import listeners.UtensilSelectorListener;

public @SuppressWarnings("serial")
class JavaPaintGui extends JFrame{
	
	private JButton saveButton = null;
	//JButton that opens save dialog
	
	private StyleSource styleSource = null;
	
	private CanvasPanel canvasPanel = null;
	//The panel that is drawn upon

	private MouseDetectorListener mouser = null;
	//The mouse listener (listens for clicks and drags)

	private JComboBox utensilSelector = null;
	//Combo Box to select utensil
	//Populated by availibleUtensils

	private JButton resetButton = null;
	//Button to clear PaintPanel (Empties the ArrayList)

	private JColorChooser colorChooser = null;
	//Color selector for utensil

	JavaPaintGui(){
		//Primary constructor
		//Parameter specifies what to populate UtensilSelector with
		
		super("JavaPaint");
		//Title the window
		
		styleSource = new StyleSource();
		styleSource.setSelectedColor(Color.black);
		styleSource.setSelectedUtensil(AvailableUtensils.OVAL);

		canvasPanel = new CanvasPanel();
		//Instantiate a CanvasPanel
		//Container for BufferedCanvas

		canvasPanel.setPreferredSize(new Dimension(500, 500));

		mouser = new MouseDetectorListener(new UtensilFactory(styleSource));
		//Create a new MouseDetectorListener

		canvasPanel.addMouseListener(mouser);
		canvasPanel.addMouseMotionListener(mouser);
		//Add listener for click (MouseListener) and drag (MouseMotionListener)

		canvasPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//Draw a border around the drawing area
		
		utensilSelector = new JComboBox(AvailableUtensils.values());
		//Create a JComboBox to pick utensils
		
		utensilSelector.addActionListener(new UtensilSelectorListener(styleSource));
		
		resetButton = new JButton("Clear");
		//Add a reset button that says Clear

		resetButton.addActionListener(new ClearListener(canvasPanel));
		//Listen to the clear button

		colorChooser = new JColorChooser(Color.black);
		//Initialize the color chooser on black
		
		colorChooser.getSelectionModel().addChangeListener(new ColorPickerListener(styleSource));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveListener(this, canvasPanel.getBufferedCanvas()));

		addComponents();
		pack();
		setVisible(true);
	}
	
	public AvailableUtensils getSelectedUtensil(){
		//Get currently selected element from utensilSelector
		return (AvailableUtensils) utensilSelector.getSelectedItem();
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
