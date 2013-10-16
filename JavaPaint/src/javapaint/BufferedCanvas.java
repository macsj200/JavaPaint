package javapaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BufferedCanvas extends BufferedImage{
	//BufferedCanvas
	
	private ArrayList<Utensil> elements = null;
	//Utensils list
	
	private Graphics2D g2 = null;
	//Painting object
	
	public BufferedCanvas(int width, int height, int imageType, ArrayList<Utensil> elements) {
		super(width, height, imageType);
		this.elements = elements;
		
		g2 = createGraphics();
	}
	
	public void renderEverything(){
		Graphics2D g2d = (Graphics2D) g2.create();
		//Create a new graphics context from g2
		
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
}
