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
import listeners.ColorPickerListener;
import listeners.MouseDetectorListener;
import listeners.SaveListener;
import listeners.UtensilSelectorListener;

public @SuppressWarnings("serial")
class JavaPaintGui extends JFrame{
	private JMenuBar menuBar = null;
	private JMenu fileMenu = null;

	private JMenuItem[] fileMenuItems = null;

	private JButton saveButton = null;

	private CanvasPanel drawPanel = null;
	//The panel that is drawn upon

	private MouseDetectorListener mouser = null;
	//The mouse listener (listens for clicks and drags)

	private String[] availableUtensils = {"Oval", "Rectangle"};
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

		menuBar = new JMenuBar();

		fileMenuItems = new JMenuItem[1];
		fileMenuItems[0] = new JMenuItem("Save");

		fileMenu = new JMenu("File");

		drawPanel = new CanvasPanel();
		//Instantiate a PaintPanel
		
		utensilSelector = new JComboBox<String>(availableUtensils);
		utensilSelector.addActionListener(new UtensilSelectorListener(this));
		//Listen to utensilSelector

		drawPanel.setPreferredSize(new Dimension(500, 500));

		mouser = new MouseDetectorListener(this);

		drawPanel.addMouseListener(mouser);
		drawPanel.addMouseMotionListener(mouser);
		//Add listener for click (MouseListener) and drag (MouseMotionListener)

		drawPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//Draw a border around the drawing area
		
		utensilSelector = new JComboBox<String>(availableUtensils);
		utensilSelector.addActionListener(new UtensilSelectorListener(this));
		//Listen to utensilSelector

		resetButton = new JButton("Clear");
		//Add a reset button that says Clear

		resetButton.addActionListener(new ClearListener(drawPanel));
		//Listen to the clear button

		colorChooser = new JColorChooser(Color.black);
		//Initialize the color chooser on black

		colorChooser.getSelectionModel().addChangeListener(new ColorPickerListener(this));
		//Listen to the color selector


		//sizer = new SizeSelector(drawPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveListener(this, drawPanel.getBufferedCanvas()));

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
		return drawPanel;
	}

	private void addComponents(){
		//Add all of the components :)
		//Note the use of getContentPane()
		for(int i = 0; i < fileMenuItems.length; i++){
			fileMenu.add(fileMenuItems[i]);
		}

		menuBar.add(fileMenu);

		//getContentPane().add(menuBar);
		getContentPane().add(drawPanel);
		getContentPane().add(utensilSelector);
		getContentPane().add(resetButton);
		getContentPane().add(saveButton);
		getContentPane().add(colorChooser);
		//getContentPane().add(sizer);
	}
}