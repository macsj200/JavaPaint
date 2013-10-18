package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javapaint.JavaPaintGui;
import javapaint.Utensil;

import javax.swing.JComboBox;

public class UtensilSelectorListener implements ActionListener{
	private JavaPaintGui javaPaintGui = null;
	public UtensilSelectorListener(JavaPaintGui javaPaintGui){
		this.javaPaintGui = javaPaintGui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		@SuppressWarnings("unchecked")
		JComboBox<String> cb = (JComboBox<String>) arg0.getSource();
        String selected = (String)cb.getSelectedItem();
		javaPaintGui.getCanvasPanel()
			.setUtensil(new Utensil(selected, null, javaPaintGui.getSelectedColor()));
	}

}
