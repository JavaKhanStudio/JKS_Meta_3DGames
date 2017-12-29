package JavaKhan.M3DV.Asset;

import javax.persistence.Entity;

import JavaKhan.M3DV.Skin.Indexed_Skin;

@Entity
public class Asset_Decoration extends Indexed_AssetModel implements Cloneable
{

public static final String DECO_3D_PATH = "JavaKhan/Assets3D/Decoration/" ;

	
	public Asset_Decoration(String name, String assetPath, Indexed_Skin skin, float size,float hauteur)
	{
		super(name,assetPath,"",new Float[3],size,hauteur) ;
		rotation[0] = 0f ;
		rotation[1] = 0f ;
		rotation[2] = 0f ; 
		setSkin(skin) ;
	}

	public static String getObstacle3dPath() 
	{return DECO_3D_PATH;}
}
