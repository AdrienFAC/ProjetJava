package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.GestionChangementImg;
import Controleur.GestionImg;
import Controleur.GestionTriImg;
import Modele.ImageModel;
import Modele.MainModel;

public class AfficheurInfo extends Panel implements ActionListener {

	GestionImg mm = null;
	MainModel mold = null;
	AfficheurImage imDef = null;
	GestionChangementImg chanIm = null;
	Color [] c = {Color.blue,Color.red,Color.green,Color.yellow,Color.pink,Color.orange,Color.magenta,Color.cyan};
	String [] co ={"bleu","rouge","vert","jaune","rose","orange","magenta","cyan"};
	Panel p = null;
	Afficheurtri afftri =null;
	Afficherliste lis = null;
	
	ImageModel img = null;
	TextField Taille = null; 
	TextField sup = null;
	TextField tit = null;
	TextField tag = null;
	TextField Couleur = null;
	TextField not = null;

	public AfficheurInfo(Afficheurtri tri) throws IOException {

		this.mm = tri.mm;
		this.mold = tri.mold;
		this.imDef = tri.imDef;
		this.chanIm = tri.chanIm;
		this.lis = tri.list;
		this.afftri = tri;
		
		this.p = new Panel();
		BoxLayout layout = new BoxLayout(this.p,BoxLayout.PAGE_AXIS);
		this.p.setLayout(layout);
		layout.preferredLayoutSize(this.p);
		this.p.setPreferredSize(new Dimension(300,550));
		this.p.setBackground(new Color(153,153,153));

		JLabel info = new JLabel();
		info.setText("INFORMATIONS");
		info.setBorder(BorderFactory.createLineBorder(Color.white));
		
		this.Taille = new TextField("");
		this.Couleur = new TextField("");
		this.sup = new TextField("");
		this.not = new TextField("");
		this.tag = new TextField("");
		this.tit = new TextField("");
		
		this.info(tri.mold.lst_images.get(this.afftri.mm.indexActu));
		
		JButton suivant = new JButton();
		suivant.setBounds(1400,0 , 80, 20);
		suivant.setText("suivant");
		suivant.addActionListener(this);
		this.p.add(info);
		this.p.add(Taille);
		this.p.add(Box.createVerticalStrut(5));
		this.p.add(Couleur);
		this.p.add(Box.createVerticalStrut(5));
		this.p.add(sup);
		this.p.add(Box.createVerticalStrut(5));
		this.p.add(tit);
		this.p.add(Box.createVerticalStrut(5));
		this.p.add(tag);
		this.p.add(Box.createVerticalStrut(5));
		this.p.add(not);
		this.p.add(Box.createVerticalStrut(5));

		this.p.add(suivant);
		this.add(this.p);
	}

	public void info(ImageModel img) {
		
				
		this.Taille.setText(new Taille(img.getHeight(),img.getWidth()).toString());
		for(int i=0;i<c.length;i++) {
			if( img.FindColor(c[i])) {
				Couleur.setText(Couleur.getText() +" "+ co[i]);	
			}

		}

		
		this.sup.setText(new Sup(new Taille(img.getHeight(),img.getWidth())).toString());
		
		this.tit.setText(img.getTitre().toString());
		
		this.tag.setText(img.lst_tags.toString());
		
		this.not.setText(new Note(img.getNote()).toString());
		
		
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if(evt.getActionCommand() == "suivant") {
			String name = this.chanIm.nameImgSuivant(mm, imDef);
			this.imDef.changeImgDefault(name);
			this.info(this.afftri.mold.lst_images.get(this.afftri.mm.indexActu));
			this.lis.changeList();
		}

	}

}
