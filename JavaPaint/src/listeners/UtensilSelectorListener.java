package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javapaint.StyleSource;
import javax.swing.JComboBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import utensils.AvailableUtensils;

public class UtensilSelectorListener implements ActionListener {
	private StyleSource styleSource = null;

	public UtensilSelectorListener(StyleSource styleSource) {
		this.styleSource = styleSource;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		styleSource.setSelectedUtensil((AvailableUtensils)
				((JComboBox) arg0.getSource()).getSelectedItem());
	}

}
