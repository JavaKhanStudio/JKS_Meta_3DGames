package JKS.T3D.Sky.Building;

import com.jme3.app.state.AbstractAppState;

import JKS.T3D.Head.GVars.GVars_Soul_Model;
import jme3utilities.sky.SkyControl;

public class TA_SkyHeart extends AbstractAppState 
{
	SkyControl skyControl ;
	final float speed = 0.4f; 
	float timeMove ; 
	
	public TA_SkyHeart(SkyControl SkyControl) 
	{
		skyControl = SkyControl ; 
		GVars_Soul_Model.getApp().getStateManager().attach(this) ;
	}
	
	
	 @Override
	 public void update(float tpf) 
	 {
		 
		 timeMove = speed * tpf ; 
		 if(!(skyControl.getSunAndStars().getHour() + timeMove < 24)) {
			 skyControl.getSunAndStars().setHour(0);
		 }
		 
		 skyControl.getSunAndStars().setHour(skyControl.getSunAndStars().getHour() + timeMove);
	 }
	
	
	
}
