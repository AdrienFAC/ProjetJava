package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import Controleur.GestionChangementImg;
import Controleur.GestionImg;
import Controleur.GestionNote;
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
	GestionChangementImg changeImg;
	GestionNote not;
	
	public GestionGr() throws IOException{
		
		this.mm = new MainModel();
		this.modl = new ImageModel();
		this.ges = new GestionImg(mm);
		this.tri = new GestionTriImg(mm);
		this.changeImg = new GestionChangementImg(mm);
		this.not = new GestionNote(mm, changeImg);
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1500,1000));
		
		AfficheurImage panneauH = new AfficheurImage(modl, mm);
		this.add(panneauH, BorderLayout.CENTER);
		
		AfficheurRating panneauG = new AfficheurRating(modl, not);
		this.add(panneauG, BorderLayout.NORTH);

		
		Afficherliste panneaub = new Afficherliste(mm);
		this.add(panneaub, BorderLayout.SOUTH);
		
		Afficheurtri panneaug = new Afficheurtri(modl, mm,  ges, tri, panneaub, panneauH, changeImg);
		this.add(panneaug , BorderLayout.WEST);
		
		AfficheurInfo panneaud = new AfficheurInfo(modl,mm,t,a, ges, changeImg);
		this.add(panneaud, BorderLayout.EAST);
		
		
	    this.setBackground(new Color(204,204,204));
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

