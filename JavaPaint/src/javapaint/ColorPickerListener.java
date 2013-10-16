package javapaint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ColorPickerListener implements ActionListener{
	Utensil ut = null;
	
	ColorPickerListener(PaintPanel p){
		ut = p.getUtensil();
	}
	
	public void setColor(Color c){
		ut.setColor(c);
	}
	
	public void actionPerformed(ActionEvent ae){
		JComboBox cb = (JComboBox) ae.getSource();
        String selected = (String)cb.getSelectedItem();
        if(selected.equals("black")){
        	setColor(Color.black);
        }
        else if (selected.equals("blue")){
        	setColor(Color.blue);
        }
	}
}
