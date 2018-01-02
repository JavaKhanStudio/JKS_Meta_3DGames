package JKS.T3D.M3DV.Asset;

import javax.persistence.Entity;

import JKS.T3D.M3DV.Skin.Indexed_Skin;

@Entity
public class Asset_Obstacle extends Indexed_AssetModel implements Cloneable
{

	public static final String OBSTACLE_3D_PATH = "JavaKhan/Assets3D/Obstacle/" ; 
	public static final String DECORATION_3D_PATH = "JavaKhan/Assets3D/Decoration/" ; 
	
	
	public Asset_Obstacle(String name, String assetPath, String texturePath, float size,float hauteur)
	{
		super(name,assetPath,texturePath,new Float[3],size,hauteur) ;
		rotation[0] = 0f ;
		rotation[1] = 0f ;
		rotation[2] = 0f ; 
	}
	
	public Asset_Obstacle(String name, String assetPath, Indexed_Skin skin, float size,float hauteur)
	{
		super(name,assetPath,"",new Float[3],size,hauteur) ;
		rotation[0] = 0f ;
		rotation[1] = 0f ;
		rotation[2] = 0f ; 
		setSkin(skin) ;
	}

	public static String getObstacle3dPath() 
	{return OBSTACLE_3D_PATH;}

//	public Indexed_Obstacle clone()
//	{  
//	    try
//	    	{return (Indexed_Obstacle) super.clone();} 
//	    catch(Exception e)
//	    	{e.printStackTrace(); return null; }
//	}
	
	
}
