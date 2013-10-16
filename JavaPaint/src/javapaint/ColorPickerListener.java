package javapaint;

import java.awt.Color;

import javax.swing.colorchooser.DefaultColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPickerListener implements ChangeListener{
	private Utensil ut = null;

	ColorPickerListener(PaintPanel p){
		ut = p.getUtensil();
	}

	public void setColor(Color c){
		ut.setColor(c);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		setColor(((DefaultColorSelectionModel) arg0.getSource()).getSelectedColor());
	}
}
