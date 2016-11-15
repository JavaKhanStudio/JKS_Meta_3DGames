package JavaKhan.M3DV.Skin;

import java.util.ArrayList;

import javax.persistence.Embeddable;

import JavaKhan.Indexed.Indexed;

@Embeddable
public class Indexed_Texturing extends Indexed
{
	ArrayList<String> path ;
	String texture ; 
		
	public Indexed_Texturing(ArrayList<String> Path, String Texture)
	{
		path = Path ;
		texture = Texture; 
	}

	public ArrayList<String> getPath()
	{return path;}

	public void setPath(ArrayList<String> path) 
	{this.path = path;}

	public String getTexture() 
	{return texture;}

	public void setTexture(String texture)
	{this.texture = texture;}
}
