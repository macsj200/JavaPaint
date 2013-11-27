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
	
	private JButton saveButton = null;
	//JButton that opens save dialog
	
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

		canvasPanel = new CanvasPanel();
		//Instantiate a CanvasPanel
		//Container for BufferedCanvas

		canvasPanel.setPreferredSize(new Dimension(500, 500));

		canvasPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//Draw a border around the drawing area
		
		String[] shapes = {"Oval", "Rectangle"};
		
		setUtensilSelector(new JComboBox(shapes));
		//TODO fix this
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
		
		mouser = new MouseDetectorListener(this);
		//Create a new MouseDetectorListener

		canvasPanel.addMouseListener(mouser);
		canvasPanel.addMouseMotionListener(mouser);
		//Add listener for click (MouseListener) and drag (MouseMotionListener)
		
		pack();
		setVisible(true);
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
		getContentPane().add(getUtensilSelector());
		getContentPane().add(resetButton);
		getContentPane().add(saveButton);
		getContentPane().add(colorChooser);
	}

	public JComboBox getUtensilSelector() {
		return utensilSelector;
	}

	public void setUtensilSelector(JComboBox utensilSelector) {
		this.utensilSelector = utensilSelector;
	}
}
