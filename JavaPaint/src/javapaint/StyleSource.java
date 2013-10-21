package javapaint;

import java.awt.Color;

import utensils.AvailableUtensils;

public class StyleSource {
	private Color selectedColor = null;
	private AvailableUtensils selectedUtensil = null;
	private boolean buildingLine = false;
	public StyleSource() {
		
	}
	public Color getSelectedColor() {
		return selectedColor;
	}
	public void setSelectedColor(Color selectedColor) {
		this.selectedColor = selectedColor;
	}
	public AvailableUtensils getSelectedUtensil() {
		return selectedUtensil;
	}
	public void setSelectedUtensil(AvailableUtensils selectedUtensil) {
		this.selectedUtensil = selectedUtensil;
	}
	
	public boolean buildingLine(){
		return buildingLine;
	}
	
	public void startLine(){
		buildingLine = true;
	}
	
	public void endLine(){
		buildingLine = false;
	}
	
}
