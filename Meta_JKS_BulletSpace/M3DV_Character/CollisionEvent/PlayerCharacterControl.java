package CollisionEvent;

import java.util.ArrayList;

import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.control.BetterCharacterControl;

import Data.Charac_Input;
import Data.Charac_Main;
import Data.Enum_EventTypes;
import JavaKhan.Son.Controler.Sounds_Object;

public class PlayerCharacterControl extends BetterCharacterControl implements PhysicsCollisionListener
{

	public Sounds_Object stepsSound ;
	public Charac_Input input ; 
	
	public float model_speed = 20.5f ; 
	public float model_speed_Strafe = 3 ; 
	public float model_speed_rotate = 0.50f ; 
	
	
	static final String soundPath = "Sounds/Effect/Deplacement/footstep_0" ; 
	
	public PlayerCharacterControl(float f, float g, float h) 
	{
		super(f,g,h) ; 
		
		ArrayList<String> valueList = new ArrayList<String>() ; 
		
		valueList.add(soundPath + "1.wav") ; 
		valueList.add(soundPath + "2.wav") ; 
		valueList.add(soundPath + "3.wav") ; 
		valueList.add(soundPath + "4.wav") ; 
		
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
		
		if(event.getNodeB().getUserData("ORIGINAL_NAME")!= null)
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
				System.out.println("Set spawn point");
			}
		}
		
		
		
	}

	//lookForStuff ; 
	

}
