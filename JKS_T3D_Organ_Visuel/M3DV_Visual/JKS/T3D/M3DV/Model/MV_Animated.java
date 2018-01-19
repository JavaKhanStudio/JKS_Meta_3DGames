package JKS.T3D.M3DV.Model;

import java.util.concurrent.Callable;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.animation.LoopMode;

import JKS.T3D.Enums.Enum_Animation;
import JKS.T3D.Head.GVars.BasicImpl;

public interface MV_Animated extends AnimEventListener, BasicImpl
{
	
	
	public AnimationControl getControl() ;
	
	
	public default AnimChannel getChannel()
	{return getControl().channel ; }
	
	public default AnimChannel getWeaponChannel()
	{return getControl().weaponChannel ; }
	

	// FOR TEST ONLY
	public default void setTheAnimation(String action,float speed,boolean loop)
	{buildAnimationOn(getChannel(),action, speed,loop) ;}
	
	public default void setAnimationAtEnd()
	{
		getChannel().setTime(getChannel().getAnimMaxTime());

		if(getWeaponChannel() != null)
		{getWeaponChannel().setTime(getWeaponChannel().getAnimMaxTime());}
	}
	
	
	public default String getCurrentAnimation()
	{return getChannel().getAnimationName() ;}
	
	public default void setAnimationIfNotAlready(Enum_Animation action,boolean loop)
	{
		if(getChannel().getAnimationName() == null || !getChannel().getAnimationName().equals(getControl().getAsset().actionPath.getAnim(action.toString())))
		{
			setTheAnimation(action,true);
		}
 	}
	
	public default void setTheAnimation(Enum_Animation action,boolean loop)
	{
		buildAnimationOn(getChannel(),action.animName, action.getSpeed(getControl().getAsset()),loop) ;
		
		if(getWeaponChannel() != null)
		{buildAnimationOn(getWeaponChannel(),action.animName, action.getSpeed(getControl().getAsset()),loop) ;}
	}

	
	public default void buildAnimationOn(final AnimChannel selectedChanel,final String action,final float speed,final boolean loop )
	{
		getApp().enqueue(new Callable<Object>()
	    {
			 public Void call()
			 {	
				try
				{
					selectedChanel.setAnim(getControl().getAsset().actionPath.getAnim(action));
					selectedChanel.setSpeed(speed);
					
					if(loop)
					{selectedChanel.setLoopMode(LoopMode.Loop) ;}
					else
					{selectedChanel.setLoopMode(LoopMode.DontLoop) ;}
				}
				catch(Exception e)
				{
					System.out.println("Aucune animation pour " + action + " as mapped " + getControl().getAsset().actionPath.getAnim(action) ) ;
					System.out.println("Dans la liste " + getControl().getAsset().actionPath);
				} 
				
				return null ; 
			 }
		});
	
	}
		

	@Override
	public default void onAnimCycleDone(AnimControl animContr, AnimChannel animChan, String arg2) 
	{
		if(animChan.getLoopMode().equals(LoopMode.DontLoop))
		{getControl().animationFinish = true ;}
	}
	
	@Override
	public default void onAnimChange(AnimControl arg0, AnimChannel arg1, String arg2)
	{
	
	}
	
}	