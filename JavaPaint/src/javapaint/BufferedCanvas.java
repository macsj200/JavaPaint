package javapaint;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BufferedCanvas extends BufferedImage{
	//BufferedCanvas
	
	
	private ArrayList<Utensil> elements = null;
	//ArrayList of Utensil objects
	//Holds everything on the screen
	//Probably a better way to do this
	
	private Graphics2D g2 = null;
	//Painting object
	
	public BufferedCanvas(int width, int height, int imageType) {
		super(width, height, imageType);
		elements = new ArrayList<Utensil>();
		
		g2 = createGraphics();
		g2.setBackground(Color.white);
		renderEverything();
	}
	
	public void renderEverything(){
		Graphics2D g2d = (Graphics2D) g2.create();
		//Create a new graphics context from g2
		
		
		if(elements.size() == 0){
			g2d.clearRect(0, 0, getWidth(), getHeight());
		}
		
		for(int i = 0; i < elements.size(); i = i + 1){
			//Iterate through the ArrayList and paint every element
			//GOT to be a better (more efficient) way to do this
			
			g2d.setColor(elements.get(i).getColor());
			//Set the current brush color
			
			g2d.fill(elements.get(i));
			//Fill a Shape object
		}
		g2d.dispose();
		//Close the graphics object
	}
	
	public void addUtensil(Utensil ut){
		//Add a utensil to the ArrayList
		elements.add(ut);
	}
	
	public void resetElements() {
		//Empties the elements ArrayList thereby clearing the screen
		//Called when clear button is pressed
		
		elements.clear();
		//Possibly inefficient...
		
		renderEverything();
	}
}
