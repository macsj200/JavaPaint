package javapaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listeners.ClearListener;
import listeners.MouseDetectorListener;
import listeners.SaveListener;

public @SuppressWarnings("serial")
class JavaPaintGui extends JFrame{
	
	private static String[] defaultAvailibleUtensils = {"Oval", "Rectangle", "Eraser"};
	
	private JButton saveButton = null;

	private CanvasPanel canvasPanel = null;
	//The panel that is drawn upon

	private MouseDetectorListener mouser = null;
	//The mouse listener (listens for clicks and drags)

	//private String[] availableUtensils = {"Oval", "Rectangle", "Eraser"};
	private String[] availableUtensils = null;
	//Array of available utensils (currently unnecessary)
	//Used to populate utensilSelector

	private JComboBox<String> utensilSelector = null;
	//Combo Box to select utensil
	//Populated by availibleUtensils

	private JButton resetButton = null;
	//Button to clear PaintPanel (Empties the ArrayList)

	private JColorChooser colorChooser = null;
	//Color selector for utensil
	
	JavaPaintGui(){
		this(defaultAvailibleUtensils);
	}

	JavaPaintGui(String[] availibleUtensils){
		super("JavaPaint");
		//Title the window

		this.availableUtensils = availibleUtensils;

		canvasPanel = new CanvasPanel();
		//Instantiate a PaintPanel
		
		utensilSelector = new JComboBox<String>(availableUtensils);
		//Listen to utensilSelector

		canvasPanel.setPreferredSize(new Dimension(500, 500));

		mouser = new MouseDetectorListener(this);

		canvasPanel.addMouseListener(mouser);
		canvasPanel.addMouseMotionListener(mouser);
		//Add listener for click (MouseListener) and drag (MouseMotionListener)

		canvasPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//Draw a border around the drawing area
		
		utensilSelector = new JComboBox<String>(availableUtensils);
		//Listen to utensilSelector

		resetButton = new JButton("Clear");
		//Add a reset button that says Clear

		resetButton.addActionListener(new ClearListener(canvasPanel));
		//Listen to the clear button

		colorChooser = new JColorChooser(Color.black);
		//Initialize the color chooser on black


		//sizer = new SizeSelector(canvasPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveListener(this, canvasPanel.getBufferedCanvas()));

		addComponents();
		pack();
		setVisible(true);
	}
	
	public String getSelectedUtensil(){
		return (String) utensilSelector.getSelectedItem();
	}
	
	public Color getSelectedColor(){
		return colorChooser.getColor();
	}
	
	public CanvasPanel getCanvasPanel(){
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
