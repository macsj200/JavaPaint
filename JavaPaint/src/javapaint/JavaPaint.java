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
	}

	JavaPaint(){
		new JavaPaintGui();
	}
}

@SuppressWarnings("serial")
class JavaPaintGui extends JFrame{
	private PaintPanel drawPanel = null;
	private MouseDetector mouser = null;
	private String[] availibleUtensils = {"Oval"};
	private JComboBox utensilSelector = null;
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
		
		utensilSelector = new JComboBox(availibleUtensils);
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
