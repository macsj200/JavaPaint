package javapaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
public class Oval extends Ellipse2D.Double implements Utensil{
	private Color c = null;
	//Color of the oval
	
	public Oval(int width, int height, Color c){
		this.width = width;
		this.height = height;
		this.c = c;
	}
	
	Oval(Dimension d, Color c){
		//Call base constructor
		this(d.width, d.height, c);
	}
	
	public Oval(Oval o) {
		//Clone the oval object
		//Used in clone() probably bad practice feels yucky
		
		this.width = o.getWidth();
		this.height = o.getHeight();
		this.x = o.x;
		this.y = o.y;
		this.c = o.c;
	}
	
	public void setX(int x){
		//Set x coordinate
		this.x = x;
	}
	
	public void setY(int y){
		//Set y coordinate
		this.y = y;
	}
	
	public int[] getCoordinates(){
		//Return an int[] of the x and y coordinates
		int[] coord = {(int) x, (int) y};
		return coord;
	}
	
	public Utensil clone(){
		//Return a copy of the object (a new object)
		//Probably bad practice
		return new Oval(this);
	}
	
	public void setColor(Color c){
		//Set the color of the utensil
		this.c = c;
	}
	
	public Color getColor(){
		//Get the color of the utensil
		return c;
	}
}
