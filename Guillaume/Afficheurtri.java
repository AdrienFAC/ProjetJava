import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

public class Afficheurtri extends Panel implements Observer {

		TextField rat ;
		Choice taille = new Choice();
		Choice titre = new Choice();
		Choice tag = new Choice();
		Choice sup= new Choice();
		String[] t= {"400x300","640x480","800x600","1024x768","1600x1200","2272x1704","2816x2112","3264x2448","3648x2736","4096x3072","4480x3360","5120x3840","7216x5412","9600x7200"};
		
		
		
		public Afficheurtri(ImageModel m){
			this.setLayout(new FlowLayout());
			Panel p = new Panel();
			
			rat = new TextField();
			for(int i=0;i<14;i++){
				sup.add(t[i]);
			}
			for(int j=0;j<m.image.length;j++){
				if (m.titre.contains(titre)){
					titre.add(m.titre);
				}
			}
			
			for(int k=0;k<m.tag.lenght;k++){
				if (m.tag.contains(tag)){
					tag.add(m.tag);
				}
			}
			
			taille.add("Grande");
			taille.add("Moyennes");
			taille.add("petit");
			taille.add("supérieur à "+sup);
			taille.add("égale à "+sup);
			
			
			
			p.add(taille);
			p.add(rat);
			p.add(sup);
			p.add(titre);
			p.add(tag);
			
			
			
			
			
			
			
			
				
				
			}
				
			

			m.addObserver(this);
		

		@Override
		public void update(Observable arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
