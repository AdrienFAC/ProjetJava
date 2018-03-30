package Adrien;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class ImageModel
{
	BufferedImage image;
	public Taille taille;
	public String titre;
	public List<String> lst_tags;
	Couleur couleur;
	int note;
	long temps;
	
	static String parseTitre(String path)
	{
		File fichier = new File(path);
		
		String result = fichier.getAbsolutePath().substring(fichier.getAbsolutePath().lastIndexOf("/")+1);
		return (result.substring(0, result.lastIndexOf(".")));
	}
	
	static Couleur findDominantColor(BufferedImage image)
	{
		int y = 0;
		int x = 0;

		int a = 0;
		int r = 0;
		int g = 0;
		int b = 0;
		
		while (y < image.getWidth())
		{
			x = 0;
			while (y < image.getHeight())
			{
				int rgb = image.getRGB(x, y);
				a += (rgb >> 24) & 0xff;
			    r += (rgb >> 16) & 0xff;
			    g += (rgb >> 8) & 0xff;
			    b += rgb & 0xff;
				y++;
			}
			x++;
		}
		
		return (new Couleur(r / (x * y), g / (x * y), b / (x * y), a / (x * y)));
	}
	
	public ImageModel(String path) throws IOException
	{
		File f;
		
	    try
	    {
	    	f = new File(path);
	    	this.image = ImageIO.read(f);
			this.taille = new Taille(image.getWidth(), image.getHeight());
			this.titre = parseTitre(path);
			this.couleur = findDominantColor(this.image);
			this.note = 0;
			this.temps = System.currentTimeMillis();;
			this.lst_tags = new ArrayList<String>();
	    }
	    catch(IOException e){ System.out.println(e); }
	}
	
	public Taille getTaille()
	{
		return (this.taille);
	}
		
	public String getTitre()
	{
		return (this.titre);
	}
	
	public List<String> getTags()
	{
		return (this.lst_tags);
	}
	
	public void addImageTag(String toAdd)
	{
		this.lst_tags.add(toAdd);
	}
	
	public int getNote()
	{
		return (this.note);
	}
	
	public Couleur getColor()
	{
		return (this.couleur);
	}
	
	public long getTemps()
	{
		return (this.temps);
	}
}
