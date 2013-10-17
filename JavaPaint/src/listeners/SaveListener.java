package listeners;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javapaint.BufferedCanvas;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SaveListener implements ActionListener {
	private JFileChooser fc = null;
	private JFrame mainFrame = null;
	private BufferedCanvas bufferedCanvas = null;
	private File file = null;
	
	public SaveListener(JFrame mainFrame, BufferedCanvas bufferedCanvas){
		this.mainFrame = mainFrame;
		this.bufferedCanvas = bufferedCanvas;
		fc = new JFileChooser();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int returnVal = fc.showSaveDialog(mainFrame);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			file = fc.getSelectedFile();
		}
		try {
			ImageIO.write(bufferedCanvas, "png", file);
		} catch (IOException e) {
			System.err.println("Couldn't write to that location!");
		}
	}

}
