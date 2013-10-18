package javapaint;

public class JavaPaint{
	public static void main(String[] args){
		new JavaPaint();
		//Instantiate a JavaPaint object (Wrapper for JavaPaintGui)
	}

	JavaPaint(){
		new JavaPaintGui();
		//Just instantiates a JavaPaintGui object
	}
}