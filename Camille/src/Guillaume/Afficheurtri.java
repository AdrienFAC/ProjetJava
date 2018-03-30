package Guillaume; 
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;

import Adrien.ImageModel;

public class Afficheurtri extends Panel  {

	TextField rat ;
	public Choice taille = new Choice();
	public Choice titre = new Choice();
	public Choice tag = new Choice();
	Choice sup= new Choice();
	String[] t= {"400x300","640x480","800x600","1024x768","1600x1200","2272x1704","2816x2112","3264x2448","3648x2736","4096x3072","4480x3360","5120x3840","7216x5412","9600x7200"};
	
	
	
	public Afficheurtri(ImageModel m){
		this.setLayout(new FlowLayout());
		
		
		Panel p = new Panel();
		p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		p.setPreferredSize(new Dimension(200,200));
		rat = new TextField();
		for(int i=0;i<14;i++){
			sup.add(t[i]);
		}
		/*for(int j=0;j<m.titre.length();j++){
			if (m.getTitre().contains((CharSequence) titre)){
				titre.add(m.getTitre());
			}
		}
		
		for(int k=0;k<m.lst_tags.size();k++){
			if (m.lst_tags.contains(tag)){
				tag.add(m.lst_tags.get(k));
			}
		}*/
		
		taille.add("Grande");
		taille.add("Moyennes");
		taille.add("petit");
		taille.add("supérieur à "+sup);
		taille.add("égale à "+sup);
		
		
		p.add(taille);
		p.add(Box.createVerticalStrut(60));
		p.add(rat);
		p.add(Box.createVerticalStrut(60));
		p.add(sup);
		p.add(Box.createVerticalStrut(20));
		p.add(titre);
		p.add(Box.createVerticalStrut(20));
		p.add(tag);
		p.add(Box.createVerticalStrut(20));
		
		

		
		this.add(p);
		
		
		
		
		
		
		
		
		
			
			
		}
	


	
	
	
	
	
}