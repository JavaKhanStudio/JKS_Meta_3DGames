package JKS.T3D.Enums;

import com.jme3.material.Material;

import JKS.T3D.Head.GVars.GVars_Soul_Model;

public interface Material_Path 
{

	
	public String getPath() ;
	
	
	public default Material getMaterial()
	{return GVars_Soul_Model.app.getAssetManager().loadMaterial(getPath()) ;}
	
//	public default Material getMaterial()
//	{return MappingFactory_Material.getAnimatedMaterial(getPath()) ;}
	
}
