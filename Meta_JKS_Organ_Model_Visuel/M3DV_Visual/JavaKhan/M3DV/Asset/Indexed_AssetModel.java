package JavaKhan.M3DV.Asset;


import javax.persistence.Entity;

import JavaKhan.Indexed.Indexed;
import JavaKhan.M3DV.Skin.Indexed_Skin;



@Entity
public abstract class Indexed_AssetModel extends Indexed
{
	public String spatialPath ; 
	public String texturePath ;
	
	public float hauteur ;
	public float grandeur ; 
	

	public float size ;
	public float zDecal ; 
	
	public Float[] rotation ;
	
	public Indexed_Skin skin ; 
	
	public String Tags ;  

	public Indexed_AssetModel(String Name, String SpatialPath, String Texture,Float[] Rotation,float SizeIndice,float Hauteur)
	{
		DBIndexName = Name ; 
		texturePath = Texture ; 
		size = SizeIndice ;
		spatialPath = SpatialPath ;
		rotation = Rotation ;
		hauteur = Hauteur ; 
	}
	
	
	public Indexed_AssetModel(String Name, String SpatialPath, Indexed_Skin Indexed_Skin,Float[] Rotation,float SizeIndice,float Hauteur)
	{
		DBIndexName = Name ; 
		skin = Indexed_Skin ; 
		size = SizeIndice ;
		spatialPath = SpatialPath ;
		rotation = Rotation ;
		hauteur = Hauteur ; 
	}
	
	public float getGrandeur() 
	{return grandeur;}


	public void setGrandeur(float grandeur) 
	{this.grandeur = grandeur;}

	public float getHauteur()
		{return hauteur;}

	public void setHauteur(float hauteur)
		{this.hauteur = hauteur;}

	public Float[] getRotation()
		{return rotation;}

	public void setRotation(Float[] rotation)
		{this.rotation = rotation;}

	public String getDBIndexName()
		{return DBIndexName;}

	public void setDBIndexName(String dBIndexName) 
		{this.DBIndexName = dBIndexName;}

	public String getSpatialPath() 
		{return spatialPath;}

	public void setSpatialPath(String sptatialPath) 
		{this.spatialPath = sptatialPath;}

	public float getSize()
		{return size;}

	public void setSize(float size) 
		{this.size = size;}

	public String getTexturePath() 
		{return texturePath;}

	public void setTexturePath(String texturePath) 
		{this.texturePath = texturePath;}
	
	public Indexed_Skin getSkin() 
		{return skin;}

	public void setSkin(Indexed_Skin skin) 
		{this.skin = skin;}

}
