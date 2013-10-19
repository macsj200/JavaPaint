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

public abstract class Utensil{
	private Shape shapeObject = null;
	//Java-supplied shape primitive
	
	private Color color = null;
	//Color of the shape
	
	public Utensil(Shape shapeObject, Color color) throws UnsupportedShapeException{
		this.color = color;
		this.shapeObject = shapeObject;
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
}
