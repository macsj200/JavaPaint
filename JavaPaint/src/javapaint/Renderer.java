package javapaint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Renderer {
	private BufferedCanvas bufferedCanvas = null;

	public Renderer(BufferedCanvas bufferedCanvas){
		this.bufferedCanvas = bufferedCanvas;
	}

	public void render(){
		(new Thread(new RenderRunnable(bufferedCanvas))).start();
	}
}

class RenderRunnable implements Runnable{
	private BufferedCanvas bufferedCanvas = null;
	private ArrayList<Utensil> elements = null;
	private Graphics2D g2 = null;

	RenderRunnable(BufferedCanvas bufferedCanvas){
		this.bufferedCanvas = bufferedCanvas;
		this.elements = bufferedCanvas.getElements();
		this.g2 = bufferedCanvas.createGraphics();
		g2.setBackground(Color.white);
	}

	@Override
	public void run(){
		renderEverything();
	}

	public void renderEverything(){
		Graphics2D g2d = (Graphics2D) g2.create();
		//Create a new graphics context from g2


		if(elements.size() == 0){
			g2d.clearRect(0, 0, bufferedCanvas.getWidth(), bufferedCanvas.getHeight());
		}

		for(int i = 0; i < elements.size(); i = i + 1){
			//Iterate through the ArrayList and paint every element
			//GOT to be a better (more efficient) way to do this

			g2d.setColor(elements.get(i).getColor());
			//Set the current brush color

			g2d.fill(elements.get(i));
			//Fill a Shape object
		}
		g2d.dispose();
		//Close the graphics object
	}
}
