package project;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageModel
{
	BufferedImage image;
	public Dimension taille;
	Color couleur;
	public String titre;
	public List<String> lst_tags;
	int note;
	long temps;
	
	static String parseTitre(String path)
	{
		File fichier = new File(path);
		
		String result = fichier.getAbsolutePath().substring(fichier.getAbsolutePath().lastIndexOf("/")+1);
		return (result.substring(0, result.lastIndexOf(".")));
	}
	
	static void UpdateColorLst(List<Couleur> couleur_lst, int rgb)
	{
		int diff;
		Couleur match = null;
		
		for (Couleur c : couleur_lst)
		{
			diff = Math.abs(c.color.getRGB() - rgb);
			if (match == null)
				match = c;
			else
			{
				if (diff < Math.abs(match.color.getRGB() - rgb))
				{
					match = c;
				}
			}
		}
		match.nb++;
	}
	
	static Color findDominantColor(BufferedImage image)
	{
		List<Couleur> couleur_lst = new ArrayList<Couleur>();
		couleur_lst.add(new Couleur(Color.WHITE));
		couleur_lst.add(new Couleur(Color.YELLOW));
		couleur_lst.add(new Couleur(Color.ORANGE));
		couleur_lst.add(new Couleur(Color.RED));
		couleur_lst.add(new Couleur(Color.PINK));
		couleur_lst.add(new Couleur(Color.MAGENTA));
		couleur_lst.add(new Couleur(Color.BLUE));
		couleur_lst.add(new Couleur(Color.GREEN));
		couleur_lst.add(new Couleur(Color.BLACK));

		int y = 0;
		int x = 0;

		int a = 0;
		int r = 0;
		int g = 0;
		int b = 0;
		
		while (x < image.getWidth())
		{			
			y = 0;
			while (y < image.getHeight())
			{
				int rgb = image.getRGB(x, y);
				a = (rgb >> 24) & 0xff;
			    r = (rgb >> 16) & 0xff;
			    g = (rgb >> 8) & 0xff;
			    b = rgb & 0xff;
			    if (!(r == g && g == b))
			    	UpdateColorLst(couleur_lst, rgb);
				y++;
			}
			x++;
		}
		int save = 0;
		int i = 0;
		for (Couleur c : couleur_lst)
		{
			if (c.nb > couleur_lst.get(save).nb)
				save = i;
			i++;
		}
		return (new Color(couleur_lst.get(save).color.getRed(), couleur_lst.get(save).color.getGreen(), couleur_lst.get(save).color.getBlue()));
	}
	
	public ImageModel()
	{
		
	}
	
	public int FindColor(Color c)
	{
		int y = 0;
		int x = 0;
		int a = 0;
		int r = 0;
		int g = 0;
		int b = 0;
		int result = 0;
		int marge = 20;
		
		while (x < image.getWidth())
		{			
			y = 0;
			while (y < image.getHeight())
			{
				int rgb = image.getRGB(x, y);
				a = (rgb >> 24) & 0xff;
			    r = (rgb >> 16) & 0xff;
			    g = (rgb >> 8) & 0xff;
			    b = rgb & 0xff;
			    System.out.println("Base: " + c.getBlue() + " r:" + r + " +" + (r + r / marge) + " -" + (r - r / marge));
			    if (((r + r / marge >= c.getRed() && r - r / marge <= c.getRed()))
			    && ((g + g / marge >= c.getGreen() && g - g / marge <= c.getGreen()))
			    && ((b + b / marge >= c.getBlue() && b - b / marge <= c.getBlue())))
			    	result++;
				y++;
			}
			x++;
		}
		return (result);
	}
	
	public ImageModel(String path, String name) throws IOException
	{
		File f;
		
	    try
	    {
	    	f = new File(path + "/" + name);
	    	this.image = ImageIO.read(f);
			this.taille = new Dimension(image.getWidth(), image.getHeight());
			this.titre = parseTitre(name);
			this.couleur = findDominantColor(this.image);
			this.note = 1;
			this.temps = System.currentTimeMillis();;
			this.lst_tags = new ArrayList<String>();
	    }
	    catch(IOException e){ System.out.println(e); }
	}

	public String getTitre()
	{
		return (this.titre);
	}

	public void setTitre(String titre)
	{
		this.titre = titre;
	}
	
	public List<String> getTags()
	{
		return (this.lst_tags);
	}

	public void setTags(List<String> lst)
	{
		this.lst_tags = lst;
	}
	
	public void addImageTag(String toAdd)
	{
		this.lst_tags.add(toAdd);
	}
	
	public int getNote()
	{
		return (this.note);
	}
	
	public void setNote(int note)
	{
		this.note = note;
	}
	
	public Color getCouleur()
	{
		return (this.couleur);
	}
	
	public void setCouleur(Color c)
	{
		this.couleur = c;
	}
	
	public long getTemps()
	{
		return (this.temps);
	}
	
	public void setTemps(long temps)
	{
		this.temps = temps;
	}
	
}
