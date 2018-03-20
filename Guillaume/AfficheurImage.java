import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AfficheurImage extends Canvas {
	
	Image im = null;
	String im_default="vide.png";
	
	public AfficheurImage(ImageModel m ){
		super();
		this.setPreferredSize(new Dimension(400,400));
		
		try {
			im = ImageIO.read(new File(im_default));
		}catch (IOException e) {
			throw new RuntimeException("L'image" + im_default +"n'est pas dans la banque de données");
			
		}
		
		m.addObserver(this);
	}
	
	public void paint(Graphics g) {
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
