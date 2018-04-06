package project;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainModel
{
	public List<ImageModel> lst_images;

	public void Debug()
	{
		for (ImageModel img : this.lst_images)
		{
			System.out.println("[" + img.titre + "]");
			System.out.println("Note: " + img.note);
			System.out.println();			
		}
	}
	
	
	static List<ImageModel> loadImages(String path) throws IOException
	{
		List<ImageModel> result;
		
		File repImages = new File(path);
		File[] imagesList = repImages.listFiles();
		result = new ArrayList<ImageModel>();
		for (File file : imagesList)
		{
			result.add(new ImageModel(path, file.getName()));
		}
		return (result);
	}
	
	public MainModel() throws IOException
	{
		this.lst_images = loadImages("images/");
	}

	public int IsPresentInList(List<ImageModel> lst, String title)
	{
		int i = 0;
		for (ImageModel img : lst)
		{
			if (img.titre == title)
				return (i);
			i++;
		}
		return (-1);		
	}
	
	public void deserialize(String outFile)
	{
		List<ImageModel> tmp_lst = new ArrayList<ImageModel>();
		
		XMLDecoder decoder = null;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(outFile)));
			tmp_lst = (ArrayList<ImageModel>) decoder.readObject();
		} catch (FileNotFoundException e) {

		} finally {
			if (decoder != null) {
				decoder.close();
			}
		}
		
		for (ImageModel img : tmp_lst)
		{
			int exist = -1;
			if ((exist = IsPresentInList(this.lst_images, img.titre)) >= 0)
			{
				this.lst_images.get(exist).note = img.note;
				this.lst_images.get(exist).couleur = img.couleur;
				this.lst_images.get(exist).lst_tags = img.lst_tags;
				this.lst_images.get(exist).temps = img.temps;
			}
		}
	}
	
	public void serialize(String inFile)
	{
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(inFile)));
           	encoder.writeObject(this.lst_images);
			encoder.flush();
		} catch (final java.io.IOException err) {
			err.printStackTrace();
		} finally {
			if (encoder != null) {
				encoder.close();
			}
		}
	}
}
