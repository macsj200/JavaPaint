package javapaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listeners.ClearListener;
import listeners.ColorPickerListener;
import listeners.MouseDetectorListener;
import listeners.SaveListener;
import listeners.UtensilSelectorListener;

public class JavaPaint{
	public static void main(String[] args){
		new JavaPaint();
		//Instantiate a JavaPaint object (Wrapper for JavaPaintGui)
	}

	JavaPaint(){
		new JavaPaintGui();
		//Just instantiates a JavaPaintGui object
	}
}