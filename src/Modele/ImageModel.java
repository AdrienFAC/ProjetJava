package Modele;

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
	public BufferedImage image;
	public Dimension taille;
	public String titre;
	public List<String> lst_tags;
	public int note;
	long temps;
	
	static String parseTitre(String path)
	{
		File fichier = new File(path);
		
		String result = fichier.getAbsolutePath().substring(fichier.getAbsolutePath().lastIndexOf("/")+1);
		return (result.substring(0, result.lastIndexOf(".")));
	}
		
	public ImageModel()
	{
		
	}
	
	private int ABS(int a, int b)
	{
		return a - b < 0 ? (a - b) * -1 : a - b;
	}
	
	private int TestColor(Color c, int r, int g, int b)
	{
		int _r, _g, _b;
		int marge = (int)(255 * 0.4);
		
		_r = (int) (r * 1.1 > 255 ? 255 : r * 1.1);
		_b = (int) (b * 1.1 > 255 ? 255 : b * 1.1);
		_g = (int) (g * 1.1 > 255 ? 255 : g * 1.1);
		if (ABS(c.getRed(), _r) < marge && ABS(c.getBlue(), _b) < marge && ABS(c.getGreen(), _g) < marge)
			return 1;
		
		_r = (int) (r * 0.9 < 0 ? 0 : r * 0.9);
		_b = (int) (b * 0.9 < 0 ? 0 : b * 0.9);
		_g = (int) (g * 0.9 < 0 ? 0 : g * 0.9);
		if (ABS(c.getRed(), _r) < marge && ABS(c.getBlue(), _b) < marge && ABS(c.getGreen(), _g) < marge)
			return 1;
		return (0);
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
		
		while (x < image.getWidth())
		{			
			y = 0;
			while (y < image.getHeight())
			{
				int rgb = image.getRGB(x, y);
				a = (rgb >> 24) & 0xff;
			    g = (rgb >> 16) & 0xff;
			    r = (rgb >> 8) & 0xff;
			    b = rgb & 0xff;
			    result += TestColor(c, r, g, b);
				y++;
			}
			x++;
		}
		return result;
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
			this.note = 1;
			this.temps = System.currentTimeMillis();;
			this.lst_tags = new ArrayList<String>();
			//Test des couleurs
			//System.out.println(titre + ": " + thsis.FindColor(Color.RED) + " " + this.FindColor(Color.GREEN) + " " + this.FindColor(Color.BLUE));
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
		
	public long getTemps()
	{
		return (this.temps);
	}
	
	public void setTemps(long temps)
	{
		this.temps = temps;
	}
	
	public int getWidth()
	{
		return (int) (this.taille.getWidth());
	}
	
	public int getHeight()
	{
		return (int) (this.taille.getHeight());
	}
}
