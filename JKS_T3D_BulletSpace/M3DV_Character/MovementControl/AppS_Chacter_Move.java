package MovementControl;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import com.jme3.animation.LoopMode;
import com.jme3.app.state.AbstractAppState;
import com.jme3.math.Vector3f;

import JKS.T3D.Camera.Settings_Camera;
import JKS.T3D.CollisionEvent.PlayerCharacterControl;
import JKS.T3D.Data.Charac_Main;
import JKS.T3D.Enums.Enum_Animation;
import JKS.T3D.Head.GVars.GVars_Soul_Model;

public class AppS_Chacter_Move extends AbstractAppState
{
	
	PlayerCharacterControl player ; 
	private Vector3f walkDirection = new Vector3f(0,0,0);
	private Vector3f viewDirection = new Vector3f(0,0,0);
	
	Vector3f vector_Front ; 
	Vector3f vector_Side ;
	
	float total ;
	int valueX ; 
	int valueY ; 
	
	public AppS_Chacter_Move(PlayerCharacterControl control)
	{
		player = control ; 
	}
	
	
	 @Override
	 public void update(float tpf) 
	 {
		 player.input.beenMoving = false ; 
		 
		 if(Settings_Camera.currentCamType == null)
			 return  ;
		 
		  switch(Settings_Camera.currentCamType)
		  {
			  case FIRST_PERSON :
			  case THIRD_PERSON :
				  normalMove(); break ;
			  case THIRD_PERSON_TOP : 
				  fromTopMove(); break ; 
			  case THIRD_PERSON_SIDE :
				  fromSideMove() ; break ; 
		  }
		

		   	if(Charac_Main.physicsCharacter.isOnGround() 
		   			&& Charac_Main.visualCharacter.getChannel().getTime() > 0)
		   	{
		   		if(player.input.beenMoving)
		        {
		        	Charac_Main.visualCharacter.setAnimationIfNotAlready(Enum_Animation.RUN, true);
		    		Charac_Main.physicsCharacter.stepsSound.tryPush();	
		        }
		        else 
		        {
		        	Charac_Main.visualCharacter.setAnimationIfNotAlready(Enum_Animation.WAIT, true);
		        }
		   	}
		   	else if (Charac_Main.visualCharacter.getChannel().getLoopMode() == LoopMode.DontLoop)
		   	{
		   		Charac_Main.visualCharacter.setAnimationIfNotAlready(Enum_Animation.JUMPING_STAY, false);
		   	}
	        
	        Charac_Main.physicsCharacter.setWalkDirection(walkDirection);
	        Charac_Main.physicsCharacter.setViewDirection(viewDirection);
	 }
	 
	 public void normalMove() 
	 {

		 vector_Front = GVars_Soul_Model.getCam().getDirection(); //augmenter signifie rotation plus lente mais avance plus rapide
		 vector_Side = GVars_Soul_Model.getCam().getLeft();
         vector_Front.y = 0;
         vector_Side.y = 0;
	       
	       viewDirection.set(vector_Front);
	       walkDirection.set(0, 0, 0);

	       if (player.input.leftStrafe) 
	       {
	           walkDirection.addLocal(vector_Side.mult(player.model_speed_Strafe));
	           player.input.beenMoving = true ; 
	       } 
	       else if (player.input.rightStrafe) 
	       {
	           walkDirection.addLocal(vector_Side.mult(player.model_speed_Strafe).negate());
	           player.input.beenMoving = true ;
	       }
	       
	       if (player.input.forward) 
	       {
	           walkDirection.addLocal(vector_Front.mult(player.model_speed));
	           player.input.beenMoving = true ;
	       } 
	       else if (player.input.backward) 
	       {
	           walkDirection.addLocal(vector_Front.mult(player.model_speed).negate());
	           player.input.beenMoving = true ;
	       }
	   }
	 
	 
	 public void fromSideMove()
	 {
		 vector_Front = GVars_Soul_Model.getCam().getLeft() ;
		 vector_Side = GVars_Soul_Model.getCam().getLeft().normalize() ;
	     
	     vector_Side.y = 0 ;
	     
	     walkDirection.set(0, 0, 0);
	     player.input.beenMoving = false ; 
	     
	     	     
	     if (player.input.leftStrafe) 
	     {
	         walkDirection.addLocal(vector_Front.mult(player.model_speed));
	         viewDirection = vector_Front ;
	         player.input.beenMoving = true ; 
	     } 
	     else if (player.input.rightStrafe) 
	     {
	         walkDirection.addLocal(vector_Front.mult(player.model_speed).negate());
	         viewDirection = vector_Front.negate() ;
	         player.input.beenMoving = true ;
	     }
	 }
	 
	 
	 public void fromTopMove()
	 {
	     walkDirection.set(0, 0, 0);
	     float total = 0 ;
	     player.input.beenMoving = false ; 
	     
	     int halfScreenX = Display.getHeight()/2 ; 
	     int halfScreenY = Display.getWidth()/2 ; 
	     
	     valueX = Mouse.getY() - halfScreenX;
	     valueY = Mouse.getX() - halfScreenY;
     	
     	 if(valueY + valueX != 0)
     	 {
     		total = Math.abs(valueX) + Math.abs(valueY) ;
     		vector_Front = new Vector3f(valueX/total,0, valueY/total)  ;
    		vector_Side = new Vector3f(-valueY/total,0,valueX/total)  ;
     	 }
     	 else
     	 {
     		vector_Front = Vector3f.ZERO ; 
     		vector_Side = Vector3f.ZERO ; 
     	 }
     	
     	 viewDirection.set(valueX - GVars_Soul_Model.app.getCamera().getRotation().getX(),0,valueY- GVars_Soul_Model.app.getCamera().getRotation().getZ()) ;
	     
	     if (player.input.leftStrafe) 
	     {
	         walkDirection.addLocal(vector_Side.mult(player.model_speed_Strafe).negate());
	         player.input.beenMoving = true ; 
	     } 
	     else if (player.input.rightStrafe) 
	     {
	         walkDirection.addLocal(vector_Side.mult(player.model_speed_Strafe));
	         player.input.beenMoving = true ;
	     }
	    
	     
	     if (player.input.forward) 
	     {
	    	 walkDirection.addLocal(vector_Front.mult(player.model_speed)); //(augmente ou reduit la vitesse de rotation a gauche, peut creer un desequilibre avec la droite)
	    	 player.input.beenMoving = true ;
	     } 
	     else if (player.input.backward) 
	     {
	    	 walkDirection.addLocal(vector_Front.mult(player.model_speed).negate()); //(augmente ou reduit la vitesse de rotation a gauche, peut creer un desequilibre avec la droite)
	    	 player.input.beenMoving = true ;
	     }
	   }
}
