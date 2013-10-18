package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javapaint.CanvasPanel;

public class ClearListener implements ActionListener{
	private CanvasPanel canvasPanel = null;
	//CanvasPanel object passed in constructor
	//Needed to call resetElements()

	public ClearListener(CanvasPanel canvasPanel){
		this.canvasPanel = canvasPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		canvasPanel.resetElements();
		//On button click (action) clear the PaintPanel
	}
}
