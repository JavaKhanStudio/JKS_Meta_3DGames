package JavaKhan.Utils.Model3D;

import java.util.concurrent.Callable;

import com.jme3.light.Light;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.PublicName.FVars_Regex;
import JavaKhan.Utils.Logger.Utils_Logger;

public class Utils_3DObject 
{

	public static void safeAdd(Spatial addIm, Node into)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				into.attachChild(addIm) ; 
				return null ; 
			}
		});

	}
	
	public static void safeAdd(Spatial addIm)
	{safeAdd(addIm, GVars_Soul_Model.app.getRootNode()) ;}
	
	public static void safeAdd(String addIm)
	{safeAdd(safeGetSpatial(addIm), GVars_Soul_Model.app.getRootNode()) ;}
	
	public static Spatial safeGetSpatial(String path)
	{
		return  GVars_Soul_Model.app.getAssetManager().loadModel(path) ;
	}
	
	public static void safeRemove(Spatial remove, Node from)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				from.detachChild(remove) ; 
				return null ; 
			}
		});
	}

	
	
	
	public static void safeRemove(final Spatial spa)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			  public Void call()
			  {
				  try
				  	{GVars_Soul_Model.app.getRootNode().detachChild(spa) ;}
				  catch(NullPointerException e)
				  	{}
				  
			      return null;
			  }
		});  
	}
	
	public static void safeRemove(final Light spa)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			  public Void call()
			  {
				  try
				  	{GVars_Soul_Model.app.getRootNode().removeLight(spa) ;}
				  catch(NullPointerException e)
				  	{}
				  
			      return null;
			  }
		});  
	}
	
	public static void safeRemove(String remove, Node from)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				from.detachChildNamed(remove) ; 
				return null ; 
			}
		});
	}
	
	public static void safeMaterialChange(Spatial spa, Material mat)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				spa.setMaterial(mat);
				return null ; 
			}
		});
	}
	
	public static Spatial loadDirect(String path) 
	{return GVars_Soul_Model.app.getAssetManager().loadModel(path) ; }
	
	
	public static Spatial getNode(Node rootNode, String name) 
	{
		if(name.contains(FVars_Regex.findNode))
		{
			Node lookingIn = null ;
			
			for(String path : name.split(FVars_Regex.findNode))
			{
				if(rootNode.getChild(path) instanceof Node)
					lookingIn = (Node) rootNode.getChild(path) ;
				else if(rootNode.getChild(path) instanceof Geometry)
					return rootNode.getChild(path);
			}
			
			if(lookingIn == null)
			{Utils_Logger.logError("Model_Animation", "Impossible de trouver le node dans " + rootNode.getName() + " Avec le path " + name);}
			
			return lookingIn ; 
		}
		else if (name.equals(rootNode.getName())) 
		{return rootNode;}
		
        return rootNode.getChild(name);
    }
	
	

//	public static void imLookIm(Spatial attackerFighter, Node modeleVisuel) 
//	{
//		(attackerFighter).lookThis(modeleVisuel.getWorldTranslation());
//		
//	}
//	
}
