package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javapaint.PaintPanel;

public class ClearListener implements ActionListener{
	private PaintPanel p = null;
	//PaintPanel object passed in constructor
	//Needed to call resetElements()

	public ClearListener(PaintPanel p){
		this.p = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		p.resetElements();
		//On button click (action) clear the PaintPanel
	}
}
