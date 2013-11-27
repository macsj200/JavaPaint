package javapaint;

import java.awt.Color;
import java.awt.Shape;

public class ShapeWrapper{
	public static final Color defaultColor = Color.black;
	
	private Shape shape = null;
	private Color color = null;
	
	private static final boolean defaultFilled = true;
	
	private boolean filled;
	
	public ShapeWrapper(Shape shape, Color color, boolean filled){
		this.shape = shape;
		this.color = color;
		this.filled = filled;
	}
	
	public ShapeWrapper(Shape shape){
		this(shape, defaultColor, defaultFilled);
	}
	
	public ShapeWrapper(Shape shape, Color color){
		this(shape, color, defaultFilled);
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
}
