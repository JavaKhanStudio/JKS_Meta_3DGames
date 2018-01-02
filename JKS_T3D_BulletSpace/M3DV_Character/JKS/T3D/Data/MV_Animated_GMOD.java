package JKS.T3D.Data;

import java.util.concurrent.Callable;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.M3DV.Asset.Indexed_AssetModel;
import JKS.T3D.M3DV.Asset.Indexed_Asset_Animated;
import JKS.T3D.M3DV.Model.AnimationControl;
import JKS.T3D.M3DV.Model.MV_Animated;
import JKS.T3D.M3DV.Model.ModelVisuel;
import JKS.T3D.Utils.Model3D.Utils_3DObject;
import JKS.T3D.Utils.Model3D.Utils_AnimMaterial;

public class MV_Animated_GMOD extends ModelVisuel implements MV_Animated
{
	
	public AnimationControl controlCenter  ; 
	
	public MV_Animated_GMOD( Indexed_AssetModel Asset) 
	{
		super(Asset) ; 

		controlCenter = new AnimationControl(this,this) ;
	}
	
	
	public Indexed_Asset_Animated getAsset()
	{return (Indexed_Asset_Animated) asset ;}
	
	public void lookAt(Vector3f vector)
	{lookAt(vector, Vector3f.UNIT_Y);}
	
	
	public void putHologrameHere(final Spatial caseConcept,final String animationPath) 
	{
		if(solidHolograme == null)
		{initHolograme() ;}
		
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			 public Void call()
			 {
			 	solidHolograme.setLocalTranslation(caseConcept.getLocalTranslation());
			 	GVars_Soul_Model.app.getRootNode().attachChild(solidHolograme) ;
				buildAnimationOn(solidHolograme.holoChannel,animationPath,1,true) ; 
				return null ; 
			 }
		});
	}
	
	
	
	public void addAnimatedTexture_OnBody(Material mat)
	{Utils_AnimMaterial.applyAnimatedTexture(Utils_3DObject.getNode((Node) this.getChild(0), this.getAsset().getDirectBody()),mat,"MaterielTexture") ;}
	
	public void addAnimatedTexture_OnWeapon(Material mat)
	{Utils_AnimMaterial.applyAnimatedTexture(Utils_3DObject.getNode((Node) this.getChild(0), this.getAsset().getDirectWeapon()),mat,"MaterielTexture") ;}

	@Override
	public AnimationControl getControl() 
	{return controlCenter;}

}	