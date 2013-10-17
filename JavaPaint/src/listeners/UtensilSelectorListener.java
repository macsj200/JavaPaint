package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javapaint.Oval;
import javapaint.CanvasPanel;
import javapaint.Rectangle;

import javax.swing.JComboBox;

public class UtensilSelectorListener implements ActionListener{
	private CanvasPanel p = null;
	public UtensilSelectorListener(CanvasPanel p){
		this.p = p;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		@SuppressWarnings("unchecked")
		JComboBox<String> cb = (JComboBox<String>) arg0.getSource();
        String selected = (String)cb.getSelectedItem();
		if(selected.equals("Oval")){
			p.setUtensil(new Oval(11,11, p.getUtensil().getColor()));
		}
		else if(selected.equals("Rectangle")){
			p.setUtensil(new Rectangle(11,11, p.getUtensil().getColor()));
		}
	}

}
