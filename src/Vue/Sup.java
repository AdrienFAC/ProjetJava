package Vue;

public class Sup {
	
	String prop;
	
	public Sup(Taille t) {
		if (t.largeur<=500 && t.longueur<=500) {
			prop="petite";
		}
		if (t.largeur>500 && t.longueur>500) {
			prop="moyenne";
		}
		if (t.largeur>1500 && t.longueur>1500) {
			prop="grande";
		}
		
	}
	public String toString() {
		return prop;
		
	}

}
