package exceptions;

import utensils.AvailableUtensils;

@SuppressWarnings("serial")
public class UnsupportedShapeException extends Exception {
	private AvailableUtensils shapeEnum = null;
	//String representation of the shape
	
	public UnsupportedShapeException(AvailableUtensils shapeEnum){
		super();
		this.shapeEnum = shapeEnum;
	}
	
	public AvailableUtensils getShapeEnum(){
		return shapeEnum;
		//Used for error message
	}
}
