import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainModel
{
	List<ImageModel> lst_images;
	
	public static void main(String[] args) throws IOException
	{
		MainModel projet = new MainModel();
		//Charger fichier XML
		//Complete les informations
	}
	
	static List<ImageModel> loadImages(String path) throws IOException
	{		
		List<ImageModel> result;
		
		File repImages = new File(path);
		File[] imagesList = repImages.listFiles();
		result = new ArrayList<ImageModel>();
		for (File file : imagesList)
		{
			result.add(new ImageModel(file.getName()));
		}
		return (result);
	}
	
	public MainModel() throws IOException
	{
		this.lst_images = loadImages("images/");
	}
}
