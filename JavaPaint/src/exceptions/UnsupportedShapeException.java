package exceptions;

@SuppressWarnings("serial")
public class UnsupportedShapeException extends Exception {
	private String shapeString = null;
	//String representation of the shape
	
	public UnsupportedShapeException(String shapeString){
		super();
		this.shapeString = shapeString;
	}
	
	public String getShapeString(){
		return shapeString;
		//Used for error message
	}
}
