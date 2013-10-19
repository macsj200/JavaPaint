package javapaint;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import utensils.Utensil;

@SuppressWarnings("serial")
public class CanvasPanel extends JPanel{
	private Utensil utensil = null;
	//Currently loaded Utensil object
	
	private BufferedCanvas bufferedCanvas = null;
	//Use a buffered image to render stuff

	CanvasPanel(){
		this.setPreferredSize(new Dimension(500, 500));
		bufferedCanvas = new BufferedCanvas(getPreferredSize().width, 
				getPreferredSize().height, BufferedImage.TYPE_INT_ARGB);
		//Make a new BufferedImage for to render stuff
	}

	public void loadUtensil(Utensil utensil){
		//Load in a new utensil
		setUtensil(utensil);
		bufferedCanvas.addUtensil(utensil);
	}
	
	private void setUtensil(Utensil utensil){
		this.utensil = utensil;
	}
	
	public void rerender(){
		//Redraw everything
		
		bufferedCanvas.threadedRender();
		revalidate();
		repaint();
	}
	
	public void resetElements(){
		//Clear the canvas of all elements
		//Empties the ArrayList
		
		bufferedCanvas.resetElements();
		revalidate();
		repaint();
	}

	public Utensil getUtensil(){
		//Get the current utensil
		return utensil;
	}

	public void paintComponent(Graphics g){
		//Override paintComponent() method to paint BufferedCanvas
		
		super.paintComponent(g);
		//Let the normal paintComponent() method do its thing
		
		Graphics2D g2d = (Graphics2D) g.create();
		//Make a new context
		
		g2d.drawImage(bufferedCanvas, 0, 0, null);
		//Write the image
		
		g2d.dispose();
		//We're all done with that
	}
	
	public BufferedCanvas getBufferedCanvas(){
		//Get a reference to the BufferedCanvas object behind this panel
		
		return bufferedCanvas;
	}
}