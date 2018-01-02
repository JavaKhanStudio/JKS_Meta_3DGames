package MovementControl;

import com.jme3.app.state.AbstractAppState;
import com.jme3.math.Vector3f;

import JKS.T3D.Camera.Settings_Camera;
import JKS.T3D.Clavier.Control_Clavier;
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
	
	public AppS_Chacter_Move(PlayerCharacterControl control)
	{
		player = control ; 
	}
	
	
	 @Override
	 public void update(float tpf) 
	 {
		  player.input.beenMoving = false ; 
		  
		  if(Settings_Camera.normalState)
			  normalMove();
		  else if(Settings_Camera.fromTopState)
			  fromTopMove();
		  else if(Settings_Camera.fromSideState)
			  fromSideMove() ;

		   	if(Charac_Main.physicsCharacter.isOnGround() && Charac_Main.visualCharacter.animationFinish)
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
		   	else 
		   	{
		   		//Charac_Main.visualCharacter.setAnimationIfNotAlready(Enum_Animation.WAIT, true);
		   	}
	        
	        Charac_Main.physicsCharacter.setWalkDirection(walkDirection);
	        Charac_Main.physicsCharacter.setViewDirection(viewDirection);
		 
		
	 }
	 
	 public void normalMove() 
	 {
		   
		 //initTheDirection() ;
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
	       
	       if (player.input.leftRotate)
	       {
	           viewDirection.addLocal(vector_Side.mult(player.model_speed_rotate)); //(augmente ou reduit la vitesse de rotation a gauche, peut creer un desequilibre avec la droite0)
	           player.input.beenMoving = true ;
	       } 
	       else if (player.input.rightRotate) 
	       {
	           viewDirection.addLocal(vector_Side.mult(player.model_speed_rotate).negate());
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
		//initTheDirection() ;
		 vector_Front = GVars_Soul_Model.getCam().getLeft() ;
		 vector_Side = GVars_Soul_Model.getCam().getLeft().normalize() ;
	     
	     vector_Side.y = 0 ;
	     
	     //System.out.println("dir" + camUp.toString());
	     walkDirection.set(0, 0, 0);
	     player.input.beenMoving = false ; 
	     
	     if (player.input.leftStrafe) 
	     {
	         walkDirection.addLocal(vector_Front.mult(player.model_speed));
	         player.input.beenMoving = true ; 
	     } 
	     else if (player.input.rightStrafe) 
	     {
	         walkDirection.addLocal(vector_Front.mult(player.model_speed).negate());
	         player.input.beenMoving = true ;
	     }
	     
	     
//	     if (player.input.leftStrafe) 
//	     {
//	         walkDirection.addLocal(vector_Front.mult(player.model_speed_Strafe));
//	         player.input.beenMoving = true ; 
//	     } 
//	     else if (player.input.rightStrafe) 
//	     {
//	         walkDirection.addLocal(vector_Front.mult(player.model_speed_Strafe).negate());
//	         player.input.beenMoving = true ;
//	     }
	    
	     
	     if (player.input.forward) 
	     {
	    	 walkDirection.addLocal(vector_Side.mult(player.model_speed)); //(augmente ou reduit la vitesse de rotation a gauche, peut creer un desequilibre avec la droite)
	    	 player.input.beenMoving = true ;
	     } 
	     else if (player.input.backward) 
	     {
	    	 walkDirection.addLocal(vector_Side.mult(player.model_speed).negate()); //(augmente ou reduit la vitesse de rotation a gauche, peut creer un desequilibre avec la droite)
	    	 player.input.beenMoving = true ;
	     }
	 }
	 
	 
	 public void fromTopMove()
	 {
	     
	    //initTheDirection() ;
		 vector_Front = GVars_Soul_Model.getCam().getLeft() ;
		 vector_Side = GVars_Soul_Model.getCam().getUp() ;
	     
	     vector_Side.y = 0 ;
	     
	     //System.out.println("dir" + camUp.toString());
	     walkDirection.set(0, 0, 0);
	     player.input.beenMoving = false ; 
	     
	     if (player.input.leftStrafe) 
	     {
	         walkDirection.addLocal(vector_Front.mult(player.model_speed));
	         player.input.beenMoving = true ; 
	     } 
	     else if (player.input.rightStrafe) 
	     {
	         walkDirection.addLocal(vector_Front.mult(player.model_speed).negate());
	         player.input.beenMoving = true ;
	     }
	    
	     
	     if (player.input.forward) 
	     {
	    	 walkDirection.addLocal(vector_Side.mult(player.model_speed)); //(augmente ou reduit la vitesse de rotation a gauche, peut creer un desequilibre avec la droite)
	    	 player.input.beenMoving = true ;
	     } 
	     else if (player.input.backward) 
	     {
	    	 walkDirection.addLocal(vector_Side.mult(player.model_speed).negate()); //(augmente ou reduit la vitesse de rotation a gauche, peut creer un desequilibre avec la droite)
	    	 player.input.beenMoving = true ;
	     }
	   }
	 
	 
	 
	 public void initTheDirection()
	 {
		 //Normale 
		 if(Settings_Camera.normalState)
		 {
			 vector_Front = GVars_Soul_Model.getCam().getDirection(); //augmenter signifie rotation plus lente mais avance plus rapide
			 vector_Side = GVars_Soul_Model.getCam().getLeft();
		 }
		 
	    // From TOP
		 if(Settings_Camera.fromTopState)
		 {
			 vector_Front = GVars_Soul_Model.getCam().getLeft() ;
			 vector_Side = GVars_Soul_Model.getCam().getUp() ;
		 }
	 }
	 

}
