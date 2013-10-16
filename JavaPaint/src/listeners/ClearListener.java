package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javapaint.PaintPanel;

public class ClearListener implements ActionListener{
	private PaintPanel p = null;

	public ClearListener(PaintPanel p){
		this.p = p;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		p.resetElements();
	}
}
