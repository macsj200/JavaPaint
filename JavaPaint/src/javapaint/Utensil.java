package javapaint;

import java.awt.Shape;

public interface Utensil extends Shape{
	public void setX(int x);
	public void setY(int y);
	
	public int getMinSize();
	public int getMaxSize();
	public int getInitSize();
	
	public int[] getCoordinates();
	
	public Utensil clonify();
}
