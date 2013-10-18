package exceptions;

@SuppressWarnings("serial")
public class UnsupportedShapeException extends Exception {
	private String shapeString = null;
	
	public UnsupportedShapeException(String shapeString){
		super();
		this.shapeString = shapeString;
	}
	
	public String getShapeString(){
		return shapeString;
	}
}
