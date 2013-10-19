package utensils;
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
	
	private AvailableUtensils shapeEnum = null;
	//String representation of the shape object
	
	private Shape shapeObject = null;
	//Java-supplied shape primitive
	
	private Color color = null;
	//Color of the shape
	
	public Utensil(AvailableUtensils shapeEnum, int[] coordinates, Color color) throws UnsupportedShapeException{
		this.color = color;
		this.shapeEnum = shapeEnum;
		switch (shapeEnum){
		//Create a Shape primitive based on the selected Utensil
		case OVAL:
			shapeObject = new Ellipse2D.Double(coordinates[0], coordinates[1],
					11, 11);
			break;
		case RECTANGLE:
			shapeObject = new Rectangle2D.Double(coordinates[0], coordinates[1],
					11, 11);
			break;
		case ERASER:
				shapeObject = new Rectangle2D.Double(coordinates[0], coordinates[1],
						20, 20);
				break;
		default:
			//If a shape isn't here it's not supported so throw an exception
			throw new UnsupportedShapeException(shapeEnum);
		}
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
		return shapeEnum.toString();
	}
}
