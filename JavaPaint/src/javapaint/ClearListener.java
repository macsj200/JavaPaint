package javapaint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener{
	private PaintPanel p = null;

	ClearListener(PaintPanel p){
		this.p = p;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		p.resetElements();
		p.validate();
		p.repaint();
	}
}
