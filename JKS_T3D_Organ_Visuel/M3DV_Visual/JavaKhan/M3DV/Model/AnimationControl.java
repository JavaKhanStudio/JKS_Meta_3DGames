package JavaKhan.M3DV.Model;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import JavaKhan.M3DV.Asset.Indexed_Asset_Animated;
import JavaKhan.Utils.Logger.Utils_Logger;
import JavaKhan.Utils.Model3D.Utils_3DObject;

public class AnimationControl 
{
	public boolean animationFinish ; 
	
	public Indexed_Asset_Animated asset ;
	public ModelVisuel linkedToo ;
	
	public AnimChannel channel;
	public AnimControl control;
	
	public AnimChannel weaponChannel;
	public AnimControl weaponControl;
	
	public AnimationControl(ModelVisuel model, MV_Animated anim)
	{
		Spatial controlOn ; 
		linkedToo = model ;
		
		if(getAsset().bodyPath != null && !getAsset().bodyPath.isEmpty())
			controlOn = Utils_3DObject.getNode(model, getAsset().bodyPath);
		else
			controlOn = model.main ;
		
		control = controlOn.getControl(AnimControl.class);
		
		if(control != null)
		{
			channel = control.createChannel();
			System.out.println("Channel created as " + channel);
			control.addListener(anim);
		}
		else
		{Utils_Logger.logError("Model_Animation", " Impossible de trouver le control pour les animations de " + model.getName());}
		
		if(getAsset().weaponPath != null && !getAsset().weaponPath.isEmpty())
		{
			Spatial weaponModel = Utils_3DObject.getNode(model, getAsset().weaponPath);
			weaponControl = weaponModel.getControl(AnimControl.class);
			
			if(weaponControl != null)
			{
				weaponChannel = weaponControl.createChannel();
				weaponControl.addListener(anim);
			}
			else
			{Utils_Logger.logError("Model_Animation", 
					" Impossible de trouver weaponControl (animation de l'arme) de " +  model.getName()
					+ " Sur arme : " + getAsset().weaponPath);}
		}
	}
	
	public Indexed_Asset_Animated getAsset()
	{return (Indexed_Asset_Animated) linkedToo.getAsset() ;}
	
}
