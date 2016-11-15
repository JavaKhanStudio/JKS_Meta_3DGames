package JavaKhan.Utils.Model3D;

import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class Utils_AnimMaterial 
{

	public static void addAnimatedTextureOn(Material mat,Spatial spat)
	{Utils_AnimMaterial.applyAnimatedTexture(spat,mat,"MaterielTexture") ;}

	public static void addAnimatedTextureOn(Material mat,Spatial spat, String textName)
	{Utils_AnimMaterial.applyAnimatedTexture(spat,mat,textName) ;}

	public static void applyAnimatedTexture(Spatial model, Material mat, String textureData)
	{
		if(model instanceof Geometry)
		{
			Geometry solidTexture = new Geometry("Talking") ;
			
			solidTexture.setUserData(textureData, textureData);
			solidTexture.setUserData("Effect", "text");
			
			
			solidTexture.setLocalScale(model.getLocalScale());
			solidTexture.setLocalTranslation(model.getLocalTranslation());
			solidTexture.setLocalRotation(model.getLocalRotation());
			
			solidTexture.setMaterial(mat);
			solidTexture.setMesh(((Geometry)model).getMesh());
	
			model.getParent().attachChild(solidTexture);
		}
		else if(model instanceof Spatial || model instanceof Node)
		{
			for (Spatial child : ((Node) model).getChildren())
			{applyAnimatedTexture(child,mat,textureData) ;}
		}
		else
		{System.out.println("What the fuck is wrong whit you ");}
	}

	public static void removeAnimatedTextureOnIm(Spatial targetedNode,String whatRemove)
	{	
		 for (Spatial child : ((Node) targetedNode).getChildren())
		 {
			 if(child.getUserData(whatRemove) != null)
			 {Utils_3DObject.safeRemove(child, (Node) targetedNode);}
			 
			 if(child instanceof Node)
			 {removeAnimatedTextureOnIm(child,whatRemove) ; }
		 }
	}
	
}
