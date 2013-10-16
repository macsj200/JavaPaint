package javapaint;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPickerListener implements ChangeListener{
	Utensil ut = null;

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
