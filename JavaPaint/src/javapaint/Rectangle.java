package javapaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;;

@SuppressWarnings("serial")
public class Rectangle extends Rectangle2D.Double implements Utensil{
	Color c = null;
	
	Rectangle(int width, int height, Color c){
		this.width = width;
		this.height = height;
		this.c = c;
	}
	
	Rectangle(Dimension d, Color c){
		this(d.width, d.height, c);
	}
	
	public Rectangle(Rectangle o) {
		this.width = o.getWidth();
		this.height = o.getHeight();
		this.x = o.x;
		this.y = o.y;
		this.c = o.c;
	}

	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

	@Override
	public int getMinSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInitSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int[] getCoordinates(){
		int[] coord = {(int) x, (int) y};
		return coord;
	}
	
	public Utensil clonify(){
		return new Rectangle(this);
	}
	
	public void setColor(Color c){
		this.c = c;
	}
	
	public Color getColor(){
		return c;
	}
}
