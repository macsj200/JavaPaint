package javapaint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class UtensilSelectorListener implements ActionListener{
	PaintPanel p = null;
	JavaPaintGui javaPaintGui = null;
	UtensilSelectorListener(JavaPaintGui javaPaintGui, PaintPanel p){
		this.javaPaintGui = javaPaintGui;
		this.p = p;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComboBox cb = (JComboBox) arg0.getSource();
        String selected = (String)cb.getSelectedItem();
		if(selected.equals("Rectangle")){
			p.setUtensil(new Rectangle(11,11, p.getUtensil().getColor()));
		}
		else if(selected.equals("Oval")){
			p.setUtensil(new Oval(11,11, p.getUtensil().getColor()));
		}
	}

}
