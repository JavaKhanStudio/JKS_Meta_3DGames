package JKS.T3D.M3DV.Asset;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.persistence.Entity;

import JKS.T3D.M3DV.Charact.Anim.Animation_Mapping;
import JKS.T3D.M3DV.Skin.Indexed_Skin;

@Entity
public class Asset_Avatar extends Indexed_Asset_Animated
{

	
	public Asset_Avatar
	(
			String assetName, 
			String SpatialPath, 
			String Logo, 
			String Texture,
			Float[] Rotation, 
			float SizeIndice,
			float Hauteur,
			Animation_Mapping ActionPath, 
			Hashtable<String,ArrayList<String>> SoundList)
	{
		super(assetName,SpatialPath,Texture,Rotation,SizeIndice,Hauteur,Logo,ActionPath,SoundList) ;
		
	}
	
	public Asset_Avatar
	(
			String assetName, 
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
		super(assetName,SpatialPath,skin,Rotation,SizeIndice,Hauteur,Logo,BodyPath,ActionPath,SoundList) ;
		
	}
	
	public Asset_Avatar(
			String AssetName, 
			String SpatialPath, 
			String Logo, 
			Indexed_Skin Indexed_Skin,
			Float[] Rotation, 
			float SizeIndice,
			float Hauteur,
			String BodyPath ,
			String BodyName,
			String WeaponPath,
			String WeaponName,
			Animation_Mapping ActionPath, 
			Hashtable<String,ArrayList<String>> SoundList
			)
	{
		super(AssetName, SpatialPath, Indexed_Skin, Rotation, SizeIndice, Hauteur,Logo,BodyPath,BodyName,WeaponPath, WeaponName,ActionPath,SoundList);
	}
	
	
	
}
