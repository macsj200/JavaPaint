package javapaint;

public class UnsupportedShapeException extends Exception {
	private String shape = null;
	
	UnsupportedShapeException(String shape){
		super();
		this.shape = shape;
	}
	
	public String getShapeString(){
		return shape;
	}
}
