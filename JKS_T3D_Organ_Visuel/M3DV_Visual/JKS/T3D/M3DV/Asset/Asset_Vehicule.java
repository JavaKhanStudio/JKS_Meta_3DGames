package JKS.T3D.M3DV.Asset;

import javax.persistence.Entity;

import JKS.T3D.M3DV.Asset.Indexed_AssetModel;

@Entity
public class Asset_Vehicule extends Indexed_AssetModel
{

	public Asset_Vehicule(String Name, String SpatialPath, String Texture, Float[] Rotation, float SizeIndice,float Hauteur) 
	{
		super(Name, SpatialPath, Texture, Rotation, SizeIndice, Hauteur);
		
	}

}
