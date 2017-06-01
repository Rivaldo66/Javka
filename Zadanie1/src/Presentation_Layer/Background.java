package Presentation_Layer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel{
	
	private BufferedImage img;

	public Background(String s) {
		
	    try{
	    	img = ImageIO.read(new File(s));
	    	this.setPreferredSize(new Dimension(img.getHeight(), img.getWidth()));
	    }catch(FileNotFoundException e){
	    	e.printStackTrace();
	    }catch(IOException e){
	    	e.printStackTrace();
	    }
		
    }
	
	@Override
	protected void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
