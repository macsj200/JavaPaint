package javapaint;
/*
 * Wrapper interface for Shape class
 * An attempt at polymorphism (I think)
 * 
 * This probably isn't necessary
 */
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Utensil{
	private String shapeString = null;
	private Shape shapeObject = null;
	private int[] coordinates = null;
	private Color color = null;
	
	public Utensil(String shapeString, int[] coordinates, Color color){
		this.color = color;
		this.shapeString = shapeString;
		this.coordinates = coordinates;
		if(shapeString.equals("Oval")){
			shapeObject = new Ellipse2D.Double(coordinates[0], coordinates[1],
					11, 11);
		}
		else if (shapeString.equals("Rectangle")){
			shapeObject = new Rectangle2D.Double(coordinates[0], coordinates[1],
					11, 11);
		}
	}
	
	public Utensil(String shapeString, int[] coordinates){
		this(shapeString, coordinates, Color.black);
	}
	
	public int[] getCoordinates(){
		return coordinates;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
	
	public Shape getShape(){
		return shapeObject;
	}
	
	public String toString(){
		return shapeString;
	}
}
