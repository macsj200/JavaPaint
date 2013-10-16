package javapaint;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SizeSelector extends JPanel{
	private JSlider slider = null;
	private JTextField textfield = null;
	private Utensil ut = null;

	SizeSelector(PaintPanel p){
		setLayout(new FlowLayout());
		slider = new JSlider(JSlider.HORIZONTAL, 0, 0, 0);
		textfield = new JTextField();
		add(textfield);
		add(slider);
	}

	public void setUtensil(Utensil ut){
		this.ut = ut;
	}

	class SliderListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
			if (!source.getValueIsAdjusting()) {
				Integer val = (int)source.getValue();
				textfield.setText(val.toString());
			} 
		}
	}
}


