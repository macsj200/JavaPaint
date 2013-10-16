package javapaint;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel{
	private Utensil ut = null;
	//Utensil object
	//Used to paint stuff
	
	private BufferedCanvas bufferedCanvas = null;
	//Use a buffered image to render stuff
	//TODO add threads :)
	
	private ArrayList<Utensil> elements = null;
	//ArrayList of Utensil objects
	//Holds everything on the screen
	//Probably a better way to do this

	PaintPanel(){
		elements = new ArrayList<Utensil>();
		this.setPreferredSize(new Dimension(500, 500));
		bufferedCanvas = new BufferedCanvas(getPreferredSize().width, 
				getPreferredSize().height, BufferedImage.TYPE_INT_ARGB, elements);
	}

	public void setUtensil(Utensil ut){
		//Set the current utensil
		this.ut = ut;
	}

	public Utensil getUtensil(){
		//Get the current utensil
		return ut;
	}

	public void addUtensil(Utensil ut){
		//Add a utensil to the ArrayList
		elements.add(ut);
	}

	public void paintComponent(Graphics g){
		//Override paintComponent() method
		//We can use this to paint special stuff
		
		super.paintComponent(g);
		//Let the normal paintComponent() method do its thing
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.drawImage(bufferedCanvas, 0, 0, null);
		
		g2d.dispose();
	}

	public void resetElements() {
		//Empties the elements ArrayList thereby clearing the screen
		//Called when clear button is pressed
		
		elements.clear();
		//Possibly inefficient...
		
		revalidate();
		repaint();
		//Repaint the PaintPanel
	}
	
	public BufferedCanvas getBufferedCanvas(){
		return bufferedCanvas;
	}
}