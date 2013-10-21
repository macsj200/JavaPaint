package utensils;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

import javapaint.JavaPaintGui;
import javapaint.StyleSource;

import exceptions.UnsupportedShapeException;

public class UtensilFactory {
	private StyleSource styleSource = null;
	
	public UtensilFactory(StyleSource styleSource){
		//Get ref to javapaintgui object
		this.styleSource = styleSource;
	}
	
	public Utensil buildUtensil(int[] eventCoordinates) throws UnsupportedShapeException{
		Shape shapeObject = null;
		Utensil retUtensil = null;
		Color color = styleSource.getSelectedColor();
		switch (styleSource.getSelectedUtensil()){
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
				retUtensil = new EraserUtensil(shapeObject, Color.white);
				break;
		default:
			//If a shape isn't here it's not supported so throw an exception
			throw new UnsupportedShapeException(styleSource.getSelectedUtensil());
		}
		return retUtensil;
	}
	
	private Color getCurrentColor(){
		return styleSource.getSelectedColor();
	}
	
	private AvailableUtensils getCurrentShapeEnum(){
		return styleSource.getSelectedUtensil();
	}
	
	public boolean buildingLine(){
		return styleSource.buildingLine();
	}
	
	public void startLine(){
		styleSource.startLine();
	}
	
	public void endLine(){
		styleSource.endLine();
	}
}
