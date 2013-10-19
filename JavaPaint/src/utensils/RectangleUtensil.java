package utensils;

import java.awt.Color;
import java.awt.Shape;

import exceptions.UnsupportedShapeException;

public class RectangleUtensil extends Utensil{

	public RectangleUtensil(Shape shapeObject, Color color)
			throws UnsupportedShapeException {
		super(shapeObject, color);
	}
	
}
