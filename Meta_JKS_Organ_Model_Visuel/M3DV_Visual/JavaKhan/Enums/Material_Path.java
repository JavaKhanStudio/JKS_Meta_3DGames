package JavaKhan.Enums;

import com.jme3.material.Material;

import JKS_Head.GVars.GVars_Soul_Model;

public interface Material_Path 
{

	
	public String getPath() ;
	
	
	public default Material getMaterial()
	{return GVars_Soul_Model.app.getAssetManager().loadMaterial(getPath()) ;}
	
//	public default Material getMaterial()
//	{return MappingFactory_Material.getAnimatedMaterial(getPath()) ;}
	
}
