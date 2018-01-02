package JKS.T3D.CollisionEvent;

import com.jme3.scene.Spatial;

import JKS.T3D.Camera.Enum_CamType;
import JKS.T3D.Data.Charac_Main;
import JKS.T3D.Data.Enum_EventTypes;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Son.Controler.Utils_Sound;

public class EventApply 
{
	public static void actOnIt(String eventValue, Spatial target) 
	{
		switch(eventValue) 
		{
			
			case Enum_EventTypes.CAMCHANGE :
			{
				
				Enum_CamType.getType(target.getUserData(eventValue)).applyMe(target.getUserData("Cam_Info")); ;
				break ; 
			}
			case Enum_EventTypes.TOUCHE_BAD :
			{
				
				break ; 
			}
			case Enum_EventTypes.DEATH :
			{
				Charac_Main.physicsCharacter.warp(Charac_Main.last_savePoint.getWorldTranslation().add(0, 4, 0));
				Utils_Sound.makeASound("Sounds/Effect/Deplacement/water_splash.wav", 3f,1.4f);
				Utils_Sound.makeASound("Sounds/Effect/transmission.wav", 3.5f,1);
				break ; 
			}
			case Enum_EventTypes.WINNING :
			{
				Utils_Sound.breakASound("Sounds/Effect/winning.wav", 6f,0.7f);
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				
				GVars_Soul_Model.app.stop();
				//Charac_Main.app.getRootNode().detachAllChildren();
			}
			
			default : 
			{
				System.out.println("IMPOSSIBLE DE TROUVER EVENTAPPLY : " + eventValue + " SUR SPATIAL: " + target.getName());
			}
		}
		
	}
	
	
}
