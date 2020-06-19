import javax.swing.ImageIcon;

public class Pokemon
{
	//pokemon name
	private String name;
	private ImageIcon pkmSilhouette;
	private ImageIcon pkmImage;
	
	public Pokemon()
	{
		name = "none";
	}
	
	//parameterized constructor
	public Pokemon(String nombre, String pkmSil, String pkmPic)
	{
		name = nombre;
		pkmSilhouette = new ImageIcon(pkmSil);
		pkmImage = new ImageIcon(pkmPic);
	}
	
	//getters for images and names
	public String getName()
	{
		return name;
	}
	
	public ImageIcon getSilhoutte()
	{
		return pkmSilhouette;
	}
	
	public ImageIcon getImage()
	{
		return pkmImage;
	}
	
	public void display()
	{
		System.out.println(name);
	}

}
