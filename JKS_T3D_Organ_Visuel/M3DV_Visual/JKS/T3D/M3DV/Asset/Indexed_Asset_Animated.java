package JKS.T3D.M3DV.Asset;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.persistence.Entity;

import JKS.T3D.M3DV.Charact.Anim.Animation_Mapping;
import JKS.T3D.M3DV.Charact.Anim.Animation_Model;
import JKS.T3D.M3DV.Skin.Indexed_Skin;

@Entity
public abstract class Indexed_Asset_Animated extends Indexed_AssetModel
{
	
	public String imageLogo ;
	public Animation_Mapping actionPath ;
	public Hashtable<String,ArrayList<String>> soundList ; 
	public String bodyPath ;
	public String bodyName ;
	public String weaponPath; 
	public String weaponName ; 
	
	public Indexed_Asset_Animated(String Name, 
			String SpatialPath, 
			String Texture,
			Float[] Rotation, 
			float SizeIndice,
			float Hauteur,
			String Logo, 
			Animation_Mapping ActionPath, 
			Hashtable<String,ArrayList<String>> SoundList)
	{
		super(Name, SpatialPath, Texture, Rotation, SizeIndice, Hauteur);
		
		
		imageLogo = Logo ; 
		actionPath = ActionPath ;
		soundList = SoundList ;
		
	}
	
	
	public Indexed_Asset_Animated(
			String AssetName, 
			String SpatialPath, 
			Indexed_Skin Indexed_Skin,
			Float[] Rotation, 
			float SizeIndice,
			float Hauteur,
			String Logo, 
			String BodyPath ,
			Animation_Mapping ActionPath, 
			Hashtable<String,ArrayList<String>> SoundList)
	{
		super(AssetName, SpatialPath, Indexed_Skin, Rotation, SizeIndice, Hauteur);
		
		bodyPath = BodyPath ; 
		imageLogo = Logo ; 
		actionPath = ActionPath ;
		soundList = SoundList ;
	}
	
	public Indexed_Asset_Animated(
			String AssetName, 
			String SpatialPath, 
			Indexed_Skin Indexed_Skin,
			Float[] Rotation, 
			float SizeIndice,
			float Hauteur,
			String Logo, 
			String BodyPath ,
			String BodyName,
			String WeaponPath,
			String WeaponName,
			Animation_Mapping ActionPath, 
			Hashtable<String,ArrayList<String>> SoundList
			)
	{
		this(AssetName, SpatialPath, Indexed_Skin, Rotation, SizeIndice, Hauteur,Logo,BodyPath,ActionPath,SoundList);
		
		bodyName = BodyName ; 
		
		weaponPath = WeaponPath ;
		weaponName = WeaponName ; 
		
	}
	
	public String getWeaponPath()
	{return weaponPath;}
	
	public String getWeaponName()
	{return weaponName;}
	
	public String getDirectWeapon()
	{return weaponPath + "/" + weaponName ;}
	
	public String getBodyPath()
	{return bodyPath ;}
	
	public String getBodyName()
	{return bodyName ;}
	
	public String getDirectBody()
	{return bodyPath + "/" + bodyName ;}
	
	
	
	
}
