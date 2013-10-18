package exceptions;

import javapaint.AvailibleUtensils;

@SuppressWarnings("serial")
public class UnsupportedShapeException extends Exception {
	private AvailibleUtensils shapeEnum = null;
	//String representation of the shape
	
	public UnsupportedShapeException(AvailibleUtensils shapeEnum){
		super();
		this.shapeEnum = shapeEnum;
	}
	
	public AvailibleUtensils getShapeEnum(){
		return shapeEnum;
		//Used for error message
	}
}
