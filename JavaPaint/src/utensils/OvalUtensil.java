package utensils;

import java.awt.Color;
import java.awt.Shape;

import exceptions.UnsupportedShapeException;

public class OvalUtensil extends Utensil{

	public OvalUtensil(Shape shapeObject, Color color)
			throws UnsupportedShapeException {
		super(shapeObject, color);
	}
	
}
