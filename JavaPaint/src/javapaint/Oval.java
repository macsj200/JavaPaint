package javapaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
public class Oval extends Ellipse2D.Double implements Utensil{
	private int maxSize;
	private int minSize;
	private int initSize;
	
	private Color c = null;
	
	public Oval(int width, int height, Color c){
		this.width = width;
		this.height = height;
		this.c = c;
	}
	
	Oval(Dimension d, Color c){
		this(d.width, d.height, c);
	}
	
	public Oval(Oval o) {
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
		return minSize;
	}

	@Override
	public int getMaxSize() {
		return maxSize;
	}

	@Override
	public int getInitSize() {
		// TODO Auto-generated method stub
		return initSize;
	}
	
	public int[] getCoordinates(){
		int[] coord = {(int) x, (int) y};
		return coord;
	}
	
	public Utensil clonify(){
		return new Oval(this);
	}
	
	public void setColor(Color c){
		this.c = c;
	}
	
	public Color getColor(){
		return c;
	}
}
