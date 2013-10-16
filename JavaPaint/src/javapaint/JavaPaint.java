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
	
	private JComboBox utensilSelector = null;
	//Combo Box to select utensil
	//Populated by availibleUtensils
	
	private JButton resetButton = null;
	private JColorChooser colorChooser = null;


	JavaPaintGui(){
		super("JavaPaint");
		mouser = new MouseDetector();
		
		drawPanel = new PaintPanel();
		drawPanel.setPreferredSize(new Dimension(500, 500));
		drawPanel.addMouseListener(mouser);
		drawPanel.addMouseMotionListener(mouser);
		drawPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		resetButton = new JButton("Clear");
		resetButton.addActionListener(new ClearListener(drawPanel));
		
		drawPanel.setUtensil(new Oval(11,11, Color.black));
		
		colorChooser = new JColorChooser(Color.black);
		colorChooser.getSelectionModel().addChangeListener(new ColorPickerListener(drawPanel));
		
		
		//sizer = new SizeSelector(drawPanel);
		
		utensilSelector = new JComboBox(availableUtensils);
		utensilSelector.addActionListener(new UtensilSelectorListener(this, drawPanel));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		addComponents();
		pack();
		setVisible(true);
	}

	private void addComponents(){
		getContentPane().add(drawPanel);
		getContentPane().add(utensilSelector);
		getContentPane().add(resetButton);
		getContentPane().add(colorChooser);
		//getContentPane().add(sizer);
	}
}
