package javapaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class JavaPaint{
	public static void main(String[] args){
		new JavaPaint();
		//Instantiate a JavaPaint object (Wrapper for JavaPaintGui)
	}

	JavaPaint(){
		new JavaPaintGui();
		//Just instantiates a JavaPaintGui object
	}
}

@SuppressWarnings("serial")
class JavaPaintGui extends JFrame{
	private PaintPanel drawPanel = null;
	//The panel that is drawn upon
	
	private MouseDetector mouser = null;
	//The mouse listener (listens for clicks and drags)
	
	private String[] availableUtensils = {"Oval"};
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
		super("JavaPaint");
		//Title the window
		
		mouser = new MouseDetector();
		//Instantiate a MouseListener
		
		drawPanel = new PaintPanel();
		//Instantiate a PaintPanel
		
		drawPanel.setPreferredSize(new Dimension(500, 500));
		
		
		drawPanel.addMouseListener(mouser);
		drawPanel.addMouseMotionListener(mouser);
		//Add listener for click (MouseListener) and drag (MouseMotionListener)
		
		drawPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//Draw a border around the drawing area
		
		resetButton = new JButton("Clear");
		//Add a reset button that says Clear
		
		resetButton.addActionListener(new ClearListener(drawPanel));
		//Listen to the clear button
		
		drawPanel.setUtensil(new Oval(11,11, Color.black));
		//Initialize the 1st utensil object as black
		
		colorChooser = new JColorChooser(Color.black);
		//Initialize the color chooser on black
		
		colorChooser.getSelectionModel().addChangeListener(new ColorPickerListener(drawPanel));
		//Listen to the color selector
		
		
		//sizer = new SizeSelector(drawPanel);
		
		utensilSelector = new JComboBox<String>(availableUtensils);
		utensilSelector.addActionListener(new UtensilSelectorListener(this, drawPanel));
		//Listen to utensilSelector

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		addComponents();
		pack();
		setVisible(true);
	}

	private void addComponents(){
		//Add all of the components :)
		//Note the use of getContentPane()
		
		getContentPane().add(drawPanel);
		getContentPane().add(utensilSelector);
		getContentPane().add(resetButton);
		getContentPane().add(colorChooser);
		//getContentPane().add(sizer);
	}
}
