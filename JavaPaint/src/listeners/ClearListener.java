package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javapaint.CanvasPanel;

public class ClearListener implements ActionListener{
	private CanvasPanel p = null;
	//PaintPanel object passed in constructor
	//Needed to call resetElements()

	public ClearListener(CanvasPanel p){
		this.p = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		p.getBufferedCanvas().resetElements();
		//On button click (action) clear the PaintPanel
		
		p.revalidate();
		p.repaint();
	}
}
