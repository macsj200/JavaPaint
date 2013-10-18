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

import exceptions.UnsupportedShapeException;

public class Utensil{
	private String shapeString = null;
	private Shape shapeObject = null;
	private Color color = null;
	
	public Utensil(String shapeString, int[] coordinates, Color color) throws UnsupportedShapeException{
		this.color = color;
		this.shapeString = shapeString;
		if(shapeString.equals("Oval")){
			shapeObject = new Ellipse2D.Double(coordinates[0], coordinates[1],
					11, 11);
		}
		else if (shapeString.equals("Rectangle")){
			shapeObject = new Rectangle2D.Double(coordinates[0], coordinates[1],
					11, 11);
		}
		else{
			throw new UnsupportedShapeException(shapeString);
		}
	}
	
	public Utensil(String shapeString, int[] coordinates) throws UnsupportedShapeException{
		this(shapeString, coordinates, Color.black);
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
