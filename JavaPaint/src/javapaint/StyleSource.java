package javapaint;

import java.awt.Color;

import utensils.AvailableUtensils;

public class StyleSource {
	private Color selectedColor = null;
	private AvailableUtensils selectedUtensil = null;
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
	
}
