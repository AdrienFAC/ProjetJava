package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import Controleur.GestionImg;
import Controleur.GestionTriImg;
import Modele.ImageModel;
import Modele.MainModel;

public class GestionGr extends Frame implements WindowListener{
	
	public static void main(String[] args) throws IOException {
		new GestionGr();
	}
	
	ImageModel modl; 
	MainModel mm ;
	GestionTriImg tri;
	GestionImg ges;
	AfficheurImage defaut;
	Taille t;
	AfficheurImage a;
	
	public GestionGr() throws IOException{
		
		this.mm = new MainModel();
		this.modl = new ImageModel();
		ges = new GestionImg(mm);
		tri = new GestionTriImg(mm);
		defaut = new AfficheurImage(this.modl);
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1500,1000));
		
		AfficheurImage panneauH = new AfficheurImage(modl);
		this.add(panneauH, BorderLayout.CENTER);
		
		AfficheurRating panneauG = new AfficheurRating(modl);
		this.add(panneauG, BorderLayout.NORTH);

		
		Afficherliste panneaub = new Afficherliste(mm);
		this.add(panneaub, BorderLayout.SOUTH);
		
		Afficheurtri panneaug = new Afficheurtri(modl, mm,  ges, tri, panneaub, panneauH );
		this.add(panneaug , BorderLayout.WEST);
		
		AfficheurInfo panneaud = new AfficheurInfo(modl,mm,t,a);
		this.add(panneaud, BorderLayout.EAST);
		
		
		this.addWindowListener(this);
		this.pack();
		this.setVisible(true);
		
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(java.awt.event.WindowEvent evt) {
	                dispose();
	                System.exit(0);
	        } 
	} );
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

