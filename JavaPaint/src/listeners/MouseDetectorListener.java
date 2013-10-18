package listeners;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;

import javapaint.CanvasPanel;
import javapaint.JavaPaintGui;
import javapaint.Utensil;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;


public class MouseDetectorListener implements MouseInputListener{
	private int[] mouseCoordinates = null;
	private JavaPaintGui javaPaintGui = null;

	public MouseDetectorListener(JavaPaintGui javaPaintGui){
		this.javaPaintGui = javaPaintGui;
		mouseCoordinates = new int[2];
		mouseCoordinates[0] = -1;
		mouseCoordinates[1] = -1;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		mouseIt(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		mouseIt(arg0);
	}

	public int[] getMouseCoordinates(){
		return mouseCoordinates;
	}

	private void mouseIt(MouseEvent arg0){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, arg0.getComponent());
		mouseCoordinates[0] = (int) point.getX();
		mouseCoordinates[1] = (int) point.getY();
		CanvasPanel panel = (CanvasPanel) arg0.getSource();
		panel.setUtensil(new Utensil(javaPaintGui.getSelectedUtensil(), 
				mouseCoordinates, javaPaintGui.getSelectedColor()));
		panel.getBufferedCanvas().addUtensil(panel.getUtensil());
		
		panel.rerender();
	}
}
