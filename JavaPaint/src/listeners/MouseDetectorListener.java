package listeners;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javapaint.BufferedCanvas;
import javapaint.CanvasPanel;
import javapaint.JavaPaintGui;
import javapaint.ShapeWrapper;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.MouseInputListener;


public class MouseDetectorListener implements MouseInputListener{

	private Point startPoint = null;
	private Point endPoint = null;

	private BufferedCanvas canvas = null;
	private JComboBox shapePicker = null;

	private JavaPaintGui javaPaintGui = null;
	//Reference to JavaPaintGui

	private ShapeWrapper shape = null;

	private ColorSelectionModel colorPicker = null;

	public MouseDetectorListener(JavaPaintGui javaPaintGui){
		this.javaPaintGui = javaPaintGui;
		canvas = javaPaintGui.getCanvasPanel().getBufferedCanvas();
		shapePicker = javaPaintGui.getUtensilSelector();
		colorPicker = javaPaintGui.getColorChooser().getSelectionModel();
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
		if(!((String) shapePicker.getSelectedItem()).equals("Line")){
			parseSingleShape(arg0);
			//Call mouseIt()
		} else{
			startPoint = getClickCoordinates(arg0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(!((String) shapePicker.getSelectedItem()).equals("Line")){
		} else{
			endPoint = getClickCoordinates(arg0);
			canvas.addShapeWrapper(new ShapeWrapper(new Line2D.Double(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY()),colorPicker.getSelectedColor(), false));
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		if(!((String) shapePicker.getSelectedItem()).equals("Line")){
			parseSingleShape(arg0);
			//Call mouseIt()
		}
	}

	private Point getClickCoordinates(MouseEvent arg0){
		PointerInfo a = MouseInfo.getPointerInfo();

		Point currentClick = null;
		
		currentClick = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(currentClick, arg0.getComponent());
		return currentClick;
	}

	private void parseSingleShape(MouseEvent arg0){
		Point currentClick = getClickCoordinates(arg0);

		String selected = ((String)shapePicker.getSelectedItem());

		if(selected.equals("Oval")){
			shape = new ShapeWrapper(new Ellipse2D.Double(currentClick.getX(),currentClick.getY(),15,15), colorPicker.getSelectedColor());
		} else if (selected.equals("Rectangle")){
			shape = new ShapeWrapper(new Rectangle2D.Double(currentClick.getX(),currentClick.getY(),15,15), colorPicker.getSelectedColor());
		}

		if(shape != null){
			canvas.addShapeWrapper(shape);
		}

		shape = null;
	}
}
