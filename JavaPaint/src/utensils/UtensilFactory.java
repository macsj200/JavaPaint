package utensils;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javapaint.JavaPaintGui;

import exceptions.UnsupportedShapeException;

public class UtensilFactory {
	private JavaPaintGui javaPaintGui = null;
	private Utensil retUtensil = null;
	private Shape shapeObject = null;
	private Color color = null;
	
	public UtensilFactory(JavaPaintGui javaPaintGui){
		//Get ref to javapaintgui object
		this.javaPaintGui = javaPaintGui;
	}
	
	public Utensil buildUtensil(int[] eventCoordinates) throws UnsupportedShapeException{
		return buildUtensil(getCurrentShapeEnum(), eventCoordinates);
	}
	
	public Utensil buildUtensil(AvailableUtensils shapeEnum, 
			int[] eventCoordinates) throws UnsupportedShapeException{
		color = getCurrentColor();
		switch (shapeEnum){
		//Create a Shape primitive based on the selected Utensil
		case OVAL:
			shapeObject = new Ellipse2D.Double(eventCoordinates[0], eventCoordinates[1],
					11, 11);
			retUtensil = new OvalUtensil(shapeObject, color);
			break;
		case RECTANGLE:
			shapeObject = new Rectangle2D.Double(eventCoordinates[0], eventCoordinates[1],
					11, 11);
			retUtensil = new RectangleUtensil(shapeObject, color);
			break;
		case ERASER:
				shapeObject = new Rectangle2D.Double(eventCoordinates[0], eventCoordinates[1],
						20, 20);
				retUtensil = new EraserUtensil(shapeObject, color);
				break;
		default:
			//If a shape isn't here it's not supported so throw an exception
			throw new UnsupportedShapeException(shapeEnum);
		}
		return retUtensil;
	}
	
	private Color getCurrentColor(){
		return javaPaintGui.getSelectedColor();
	}
	
	private AvailableUtensils getCurrentShapeEnum(){
		return javaPaintGui.getSelectedUtensil();
	}
}
