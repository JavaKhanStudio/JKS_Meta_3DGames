package JKS.T3D.Enums;

import com.jme3.scene.Spatial;

import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Utils.Model3D.Utils_AnimMaterial;

public enum Enum_Mark 
{

	INTERROGATION("Interogation",1.25f,Enum_Material_Animated.INTEROGATION,null), ;
	
	public static float markSize = 5  ; 
	
	public String path ; 
	public String type ;  
	public float size ;
	public Material_Path mainMaterial ; 
	public Material_Path surrondingMaterial ; 
	
	Enum_Mark(String Path,float Size,Material_Path MainMaterial,Material_Path SurrondingMat) 
	{
		type = Path ; 
		size = Size ; 
		path = Enum_AssetsPath.MARK.path + Path + ".j3o" ; 
		mainMaterial = MainMaterial ; 
		surrondingMaterial = SurrondingMat ;
	}
	
	public Spatial getMarkSpatial()
	{
		Spatial returning ; 
		returning = GVars_Soul_Model.app.getAssetManager().loadModel(path) ;
		returning.scale(size) ;
		if(null != mainMaterial)
			returning.setMaterial(mainMaterial.getMaterial());
		
		if(null != surrondingMaterial)
			Utils_AnimMaterial.addAnimatedTextureOn(surrondingMaterial.getMaterial(),returning) ; 
		
		
		return returning;
	}
	
	
	
}
