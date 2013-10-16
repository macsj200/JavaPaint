package javapaint;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel{
	private Utensil ut = null;
	//Utensil object
	//Used to paint stuff
	
	private ArrayList<Utensil> elements = null;
	//ArrayList of Utensil objects
	//Holds everything on the screen
	//Probably a better way to do this

	PaintPanel(){
		this.setPreferredSize(new Dimension(500, 500));
		elements = new ArrayList<Utensil>();
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
		//Cast a Graphics2D object from g
		//Graphics2D is better for some reason
		//Not sure what g.create() does, why not just g?
		
		for(int i = 0; i < elements.size(); i = i + 1){
			//Iterate through the ArrayList and paint every element
			//GOT to be a better (more efficient) way to do this
			
			g2d.setColor(elements.get(i).getColor());
			//Set the current brush color
			
			g2d.fill(elements.get(i));
			//Fill a Shape object
		}
		g2d.dispose();
		//Close the graphics object IDK why
	}

	public void resetElements() {
		//Empties the elements ArrayList thereby clearing the screen
		
		elements.clear();
		//Possibly inefficient...
	}
}