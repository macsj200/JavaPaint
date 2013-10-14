package javapaint;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintPanel extends JPanel{
	Utensil ut = null;
	MouseDetector mouser = null;
	ArrayList<Utensil> elements = null;

	PaintPanel(){
		this.setPreferredSize(new Dimension(500, 500));
		elements = new ArrayList<Utensil>();
	}

	public void setUtensil(Utensil ut){
		this.ut = ut;
	}

	public Utensil getUtensil(){
		return ut;
	}

	public void addUtensil(Utensil ut){
		elements.add(ut);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		for(int i = 0; i < elements.size(); i = i + 1){
			g2d.fill(elements.get(i));
		}
		g2d.dispose();
	}

	public void resetElements() {
		elements.clear();
	}
}