package javapaint;

import java.awt.Color;
import java.awt.Shape;

public interface Utensil extends Shape{
	public void setX(int x);
	public void setY(int y);
	
	public int[] getCoordinates();
	
	public Utensil clone();
	public void setColor(Color c);
	public Color getColor();
}
