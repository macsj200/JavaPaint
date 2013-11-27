package listeners;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Rectangle2D;

import javapaint.BufferedCanvas;
import javapaint.CanvasPanel;
import javapaint.JavaPaintGui;
import javapaint.ShapeWrapper;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;


public class MouseDetectorListener implements MouseInputListener{

	private int[] startPoint = null;
	private int[] endPoint = null;

	private BufferedCanvas canvas = null;
	private JComboBox shapePicker = null;
	
	private JavaPaintGui javaPaintGui = null;
	//Reference to JavaPaintGui

	public MouseDetectorListener(JavaPaintGui javaPaintGui){
		this.javaPaintGui = javaPaintGui;
		canvas = javaPaintGui.getCanvasPanel().getBufferedCanvas();
		shapePicker = javaPaintGui.getUtensilSelector();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		mouseIt(arg0);
		//Call mouseIt()
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		mouseIt(arg0);
	}

	private void mouseIt(MouseEvent arg0){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, arg0.getComponent());
		
		ShapeWrapper shape = null;
		
		String selected = ((String)shapePicker.getSelectedItem());
		
		if(selected.equals("Oval")){
			shape = new ShapeWrapper(new Ellipse2D.Double(point.getX(),point.getY(),15,15), Color.black);
		} else if (selected.equals("Rectangle")){
			shape = new ShapeWrapper(new Rectangle2D.Double(point.getX(),point.getY(),15,15), Color.black);
		}
		
		canvas.addShapeWrapper(shape);
	}
}
