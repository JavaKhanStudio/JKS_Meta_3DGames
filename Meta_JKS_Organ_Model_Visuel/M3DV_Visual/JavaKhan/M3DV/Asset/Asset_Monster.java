package JavaKhan.M3DV.Asset;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.persistence.Entity;

import JavaKhan.M3DV.Charact.Anim.Animation_Mapping;
import JavaKhan.M3DV.Model.Charact_Scaling;
import JavaKhan.M3DV.Skin.Indexed_Skin;

@Entity
public class Asset_Monster extends Indexed_Asset_Animated
{

	public Charact_Scaling scaling ; 
	
	
	public Asset_Monster
	(
			String Name, 
			String SpatialPath, 
			String Logo, 
			String Texture,
			Float[] Rotation, 
			float SizeIndice,
			float Hauteur,
			Animation_Mapping ActionPath, 
			Hashtable<String,ArrayList<String>> SoundList)
	{
		super(Name,SpatialPath,Texture,Rotation,SizeIndice,Hauteur,Logo,ActionPath,SoundList) ;
		
		scaling = new Charact_Scaling() ; 
	}
	
	
	public Asset_Monster
	(
			String Name, 
			String SpatialPath, 
			String Logo, 
			Indexed_Skin skin,
			Float[] Rotation, 
			float SizeIndice,
			float Hauteur,
			String BodyPath,
			Animation_Mapping ActionPath, 
			Hashtable<String,ArrayList<String>> SoundList)
	{
		super(Name,SpatialPath,skin,Rotation,SizeIndice,Hauteur,Logo,BodyPath,ActionPath,SoundList) ;
		
		scaling = new Charact_Scaling() ; 
	}


	
	
}
