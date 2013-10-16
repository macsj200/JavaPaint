package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javapaint.Oval;
import javapaint.PaintPanel;
import javax.swing.JComboBox;

public class UtensilSelectorListener implements ActionListener{
	private PaintPanel p = null;
	public UtensilSelectorListener(PaintPanel p){
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
	}

}
