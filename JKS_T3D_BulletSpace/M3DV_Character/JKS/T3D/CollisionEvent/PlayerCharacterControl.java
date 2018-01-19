package JKS.T3D.CollisionEvent;

import java.util.ArrayList;
import java.util.List;

import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.collision.PhysicsRayTestResult;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.util.TempVars;

import JKS.T3D.Data.Charac_Input;
import JKS.T3D.Data.Charac_Main;
import JKS.T3D.Son.Controler.Sounds_Object;

public class PlayerCharacterControl extends BetterCharacterControl implements PhysicsCollisionListener
{

	public Sounds_Object stepsSound ;
	public Charac_Input input ; 
	
	public float model_speed = 20.5f ; 
	public float model_speed_Strafe = 3 ; 
	public float model_speed_rotate = 0.50f ; 
	public float model_time_forJump = 0.3f ;
	
	
	static final String soundPath = "Sounds/Effect/Deplacement/footstep_0" ; 
	static boolean asInvertGravity = false; 
	
	
	public PlayerCharacterControl(float f, float g, float h) 
	{
		super(f,g,h) ; 
		
		ArrayList<String> valueList = new ArrayList<String>() ; 
		
		valueList.add(soundPath + "1.wav") ; 
		valueList.add(soundPath + "2.wav") ; 
		valueList.add(soundPath + "3.wav") ; 
		valueList.add(soundPath + "4.wav") ; 
		
		rigidBody.setRestitution(1);
		rigidBody.setFriction(0);
		
		stepsSound = new Sounds_Object(valueList, Charac_Main.visualCharacter) ; 
		input = new Charac_Input() ; 
	}

	public void setPhysicsSpace(PhysicsSpace space)
	{
        super.setPhysicsSpace(space);
        if (space != null) {
            space.addCollisionListener(this);
        }
    }
	
	@Override
	public void collision(PhysicsCollisionEvent event) 
	{
		
		if(event.getNodeB().getUserData("ORIGINAL_NAME")!= null || event == null)
		{return ;}
		
		String eventValue = event.getNodeB().getUserData("Event"); 
		String soundValue = event.getNodeB().getUserData("Event_Dialogue"); 
		String spawnValue = event.getNodeB().getUserData("SpawnPoint"); 
		
		
		
		if(eventValue != null)
		{
			EventApply.actOnIt(eventValue,event.getNodeB()) ;
		}
		
		if(soundValue != null && event.getNodeB().getUserData("Dialogue_Done") == null)
		{
			DialogueApply.actOnIt(event.getNodeB().getUserData(event.getNodeB().getUserData("Event_Dialogue"))) ;
			event.getNodeB().setUserData("Dialogue_Done", true);
		}
		if(spawnValue != null)
		{
			if(Charac_Main.last_savePoint != event.getNodeB())
			{
				Charac_Main.last_savePoint = event.getNodeB() ;
				event.getNodeB().setUserData("SpawnPoint", null);
			}
		}
	}
	
	public void setIsOnGroud(boolean isIt)
	{onGround = isIt ;}
	
	
	public void inverseGravity(boolean inverse)
	{
		if(asInvertGravity == inverse)
			return ;
			
		localUp.negateLocal() ;
		rigidBody.setGravity(rigidBody.getGravity().negate());
		rigidBody.setLinearVelocity(new Vector3f(0,0,0));
		Charac_Main.physicsCharacter.warp(Charac_Main.physicsCharacter.getSpatialTranslation().add(0, ((Charac_Main.physicsCharacter.getFinalHeight() + 0.3f) * -localUp.y), 0));	
		asInvertGravity = inverse ;
		jumpForce.negateLocal() ;
	}
	
	
	
	Vector3f solid = new Vector3f(0,1,0) ; 
	
	@Override
	protected void checkOnGround() 
	{
        TempVars vars = TempVars.get();
        Vector3f location = vars.vect1;
        Vector3f rayVector = vars.vect2;
        float height = getFinalHeight();
        location.set(solid).multLocal(height).addLocal(this.location);
        rayVector.set(localUp).multLocal(-height - (0.1f *localUp.y)).addLocal(location);
        List<PhysicsRayTestResult> results ; 
       
        if(localUp.y > 0)
        	results = space.rayTest(location, rayVector);
        else 
        	results = space.rayTest(rayVector, location);
        
        vars.release();
        
        for (PhysicsRayTestResult physicsRayTestResult : results) 
        {
        	if (!physicsRayTestResult.getCollisionObject().equals(rigidBody)) 
            {onGround = true; return;}
        }
        
        onGround = false;
    }
	
	public void resetTurn()
	{
		asInvertGravity = false ;
	}
}
