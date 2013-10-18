package listeners;

import java.awt.Color;

import javapaint.CanvasPanel;
import javapaint.JavaPaintGui;
import javapaint.Utensil;

import javax.swing.colorchooser.DefaultColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/*
 * I think this class is where the color problem is!
 */

public class ColorPickerListener implements ChangeListener{
	private JavaPaintGui javaPaintGui = null;

	public ColorPickerListener(JavaPaintGui javaPaintGui){
		this.javaPaintGui = javaPaintGui;
	}

	public void setColor(Color c){
		javaPaintGui.getCanvasPanel().setUtensil(new Utensil(javaPaintGui.getSelectedUtensil(), 
				null, javaPaintGui.getSelectedColor()));
		javaPaintGui.getCanvasPanel().getBufferedCanvas().addUtensil(javaPaintGui.getCanvasPanel().getUtensil());
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		setColor(((DefaultColorSelectionModel) arg0.getSource()).getSelectedColor());
	}
}
