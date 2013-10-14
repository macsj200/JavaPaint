package javapaint;

import java.awt.Dimension;
import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
public class Oval extends Ellipse2D.Double implements Utensil{
	private int maxSize;
	private int minSize;
	private int initSize;
	
	Oval(int width, int height){
		this.width = width;
		this.height = height;
		
		this.minSize = 11;
		this.maxSize = 40;
		this.initSize = 11;
	}
	
	Oval(Dimension d){
		this(d.width, d.height);
	}
	
	Oval(Oval o){
		this.width = o.getWidth();
		this.height = o.getHeight();
		this.x = o.x;
		this.y = o.y;
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
}
