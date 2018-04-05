package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projet.ImageModel;

public class Afficherliste extends Panel {
	 
	private Image image2;
	private ImageIcon image1;
	
	
	public Afficherliste(ImageModel m ) {
		
	
		Panel p = new Panel();
		p.setPreferredSize(new Dimension(900,100));
		p.setLayout(new BorderLayout());
		
		JButton suivant = new JButton();
		suivant.setBounds(800,0 , 80, 20);
		suivant.setText("suivant");
		


		
		JPanel lis = new JPanel();
		lis.setLayout(new BoxLayout(lis, BoxLayout.LINE_AXIS));
		

		
		
		JPanel pane = new JPanel();
		ImageIcon image1 = new ImageIcon( "images/cellules.jpg");
		ImageIcon newimage1 = new ImageIcon(image1.getImage().getScaledInstance(image1.getIconWidth()*1/8,image1.getIconHeight()*1/8,Image.SCALE_DEFAULT));
		JLabel image = new JLabel( newimage1);
		pane.add(image);
		
		JPanel pane2 = new JPanel(); 
		ImageIcon image2 = new ImageIcon( "images/espace.jpg");
		ImageIcon newimage2 = new ImageIcon(image2.getImage().getScaledInstance(image2.getIconWidth()*1/8,image2.getIconHeight()*1/8,Image.SCALE_DEFAULT));
		JLabel imag2 = new JLabel(newimage2);
		pane2.add(imag2);
		
		JPanel pane3 = new JPanel(); 
		ImageIcon image3 = new ImageIcon( "images/bretagne.jpg");
		ImageIcon newimage3 = new ImageIcon(image3.getImage().getScaledInstance(image3.getIconWidth()*1/8,image3.getIconHeight()*1/8,Image.SCALE_DEFAULT));
		JLabel imag3 = new JLabel(newimage3);
		pane3.add(imag3);
		
		JPanel pane4 = new JPanel(); 
		ImageIcon image4 = new ImageIcon( "images/cyan.jpg");
		ImageIcon newimage4 = new ImageIcon(image4.getImage().getScaledInstance(image4.getIconWidth()*1/8,image4.getIconHeight()*1/8,Image.SCALE_DEFAULT));
		JLabel imag4 = new JLabel(newimage4);
		pane4.add(imag4);
		
		JPanel pane5 = new JPanel(); 
		ImageIcon image5 = new ImageIcon( "images/gaudi.jpg");
		ImageIcon newimage5 = new ImageIcon(image5.getImage().getScaledInstance(image5.getIconWidth()*1/8,image5.getIconHeight()*1/8,Image.SCALE_DEFAULT));
		JLabel imag5 = new JLabel(newimage5);
		pane5.add(imag5);

		
		
		lis.add(pane);
		lis.add(Box.createHorizontalStrut(5));
		lis.add(pane2);
		lis.add(Box.createHorizontalStrut(5));
		lis.add(pane3);
		lis.add(Box.createHorizontalStrut(5));
		lis.add(pane4);
		lis.add(Box.createHorizontalStrut(5));
		lis.add(pane5);
		
		p.add(suivant);
		p.add(lis,BorderLayout.CENTER);
		
		this.add(p);
		
	
	}
	
}
