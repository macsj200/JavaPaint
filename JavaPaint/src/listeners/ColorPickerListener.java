package listeners;

import javapaint.StyleSource;

import javax.swing.JColorChooser;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPickerListener implements ChangeListener {
	private StyleSource styleSource = null;

	public ColorPickerListener(StyleSource styleSource) {
		this.styleSource = styleSource;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		styleSource.setSelectedColor(((ColorSelectionModel) arg0.getSource()).getSelectedColor());
	}

}
