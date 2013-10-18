package javapaint;
/*
 * Wrapper interface for Shape class
 * An attempt at polymorphism (I think)
 * 
 */
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import exceptions.UnsupportedShapeException;

public class Utensil{
	private String shapeString = null;
	//String representation of the shape object
	
	private Shape shapeObject = null;
	//Java-supplied shape primitive
	
	private Color color = null;
	//Color of the shape
	
	public Utensil(String shapeString, int[] coordinates, Color color) throws UnsupportedShapeException{
		this.color = color;
		this.shapeString = shapeString;
		switch (shapeString){
		//Create a Shape primitive based on the selected Utensil
		case "Oval":
			shapeObject = new Ellipse2D.Double(coordinates[0], coordinates[1],
					11, 11);
			break;
		case "Rectangle":
			shapeObject = new Rectangle2D.Double(coordinates[0], coordinates[1],
					11, 11);
			break;
		case "Eraser":
				shapeObject = new Rectangle2D.Double(coordinates[0], coordinates[1],
						20, 20);
				break;
		default:
			//If a shape isn't here it's not supported so throw an exception
			throw new UnsupportedShapeException(shapeString);
		}
	}
	
	public Utensil(String shapeString, int[] coordinates) throws UnsupportedShapeException{
		//Calls primary constructor with default color black
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
		//Get string representation of shape
		return shapeString;
	}
}
