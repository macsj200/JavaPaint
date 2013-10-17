package javapaint;
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
	
	private Renderer renderer = null;
	
	public BufferedCanvas(int width, int height, int imageType) {
		super(width, height, imageType);
		elements = new ArrayList<Utensil>();
		renderer = new Renderer(this);
		threadRender();
	}
	
	public void threadRender(){
		renderer.render();
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
		
		threadRender();
	}
	
	public ArrayList<Utensil> getElements(){
		return elements;
	}
}
