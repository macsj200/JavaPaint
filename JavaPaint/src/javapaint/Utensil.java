package javapaint;
/*
 * Wrapper interface for Shape class
 * An attempt at polymorphism (I think)
 * 
 * This probably isn't necessary
 */
import java.awt.Color;
import java.awt.Shape;

public interface Utensil extends Shape{
	public void setX(int x);
	//Set the x coordinate of the utensil
	
	public void setY(int y);
	//Set the y coordinate of the utensil
	
	public int[] getCoordinates();
	//Get an int array with coordinates
	//getCoordinates()[0] = x
	//getCoordinates()[1] = y
	
	public Utensil clone();
	//Make a clone of the utensil to put into the elements ArrayList
	//Probably bad practice
	
	public void setColor(Color c);
	public Color getColor();
	//Get and set the color of the utensil
}
