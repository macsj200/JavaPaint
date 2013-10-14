package javapaint;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	MouseDetector mouser = null;
	String[] availibleUtensils = {"Oval", "Rectangle"};
	JComboBox utensilSelector = null;
	SizeSelector sizer = null;
	CardLayout layout = null;
	private JButton resetButton = null;


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
		
		drawPanel.setUtensil(new Oval(11,11));
		
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
		//getContentPane().add(sizer);
	}
}
