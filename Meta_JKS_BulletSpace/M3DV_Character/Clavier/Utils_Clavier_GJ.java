package Clavier;

import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;

import Config_Global.GVars_GJ;


public class Utils_Clavier_GJ
{

	
	public static void setupKeysId(int id, boolean first)
	{
		getInputManager().clearMappings();
		switch(id)
		{
		  	case 0://fleches simples ^ < V >
		  		setupKeys(first,KeyInput.KEY_LEFT, KeyInput.KEY_RIGHT,KeyInput.KEY_UP,
	  					KeyInput.KEY_DOWN,KeyInput.KEY_SPACE);
		  		break;
		  	case 1: // V < ^ >
		  		setupKeys(first,KeyInput.KEY_LEFT, KeyInput.KEY_RIGHT,KeyInput.KEY_DOWN,
	  					KeyInput.KEY_UP,KeyInput.KEY_SPACE);
		  		break;
		  	case 2: // V > ^ <
		  		setupKeys(first,KeyInput.KEY_RIGHT, KeyInput.KEY_LEFT,KeyInput.KEY_DOWN,
	  					KeyInput.KEY_UP,KeyInput.KEY_SPACE);
		  		break;
		  	case 3: // ^ > V <
		  		setupKeys(first,KeyInput.KEY_RIGHT, KeyInput.KEY_LEFT,KeyInput.KEY_UP,
	  					KeyInput.KEY_DOWN,KeyInput.KEY_SPACE);
		  		break;
		  	case 4: // < V > ^
		  		setupKeys(first,KeyInput.KEY_UP, KeyInput.KEY_DOWN,KeyInput.KEY_LEFT,
	  					KeyInput.KEY_RIGHT,KeyInput.KEY_SPACE);
		  		break;
		  	case 5: // < ^ V >
		  		setupKeys(first,KeyInput.KEY_UP, KeyInput.KEY_RIGHT,KeyInput.KEY_LEFT,
	  					KeyInput.KEY_DOWN,KeyInput.KEY_SPACE);
		  		break;
		  	case 6: // Z Q S D
		  		setupKeys(first,KeyInput.KEY_Q, KeyInput.KEY_D,KeyInput.KEY_Z,
	  					KeyInput.KEY_S,KeyInput.KEY_SPACE);
		  		break;
		  	case 7: // A W S D
		  		setupKeys(first,KeyInput.KEY_W, KeyInput.KEY_D,KeyInput.KEY_A,
	  					KeyInput.KEY_S,KeyInput.KEY_SPACE);
		  		break;
		  	case 8: // E R T Y 
		  		setupKeys(first,KeyInput.KEY_R, KeyInput.KEY_Y,KeyInput.KEY_E,
	  					KeyInput.KEY_T,KeyInput.KEY_SPACE);
		  		break;
		  	case 9: // CTRL F ALTGR B
		  		setupKeys(first,KeyInput.KEY_LCONTROL, KeyInput.KEY_F,KeyInput.KEY_LEFT,
	  					KeyInput.KEY_B,KeyInput.KEY_SPACE);
		  		break;
		  	case 10: // WASD
		  		setupKeys(first, 
		  				KeyInput.KEY_A, KeyInput.KEY_D, 
		  				KeyInput.KEY_W, KeyInput.KEY_S, 
		  				KeyInput.KEY_SPACE) ; break ;
		  	case 11: // ZQSD
		  		setupKeys(first, 
		  				KeyInput.KEY_Q, KeyInput.KEY_D, 
		  				KeyInput.KEY_Z, KeyInput.KEY_S, 
		  				KeyInput.KEY_SPACE) ; break ;
		}
		
		//getInputManager().addMapping("Strafe Left", new KeyTrigger(KeyInput.KEY_ESCAPE));
  	}
  	
	public static void addTestKey() 
	{
		getInputManager().addMapping("Test1",new KeyTrigger(KeyInput.KEY_1));
		getInputManager().addListener(GVars_GJ.actionLisen, "Test1");
	}
	
  	private static void setupDefaultDirectionalKeys() 
	{
  		getInputManager().addMapping("Rotate Left",new KeyTrigger(KeyInput.KEY_LEFT));
	    getInputManager().addMapping("Rotate Right",new KeyTrigger(KeyInput.KEY_RIGHT));
	    getInputManager().addMapping("Walk Forward",new KeyTrigger(KeyInput.KEY_UP));
	    getInputManager().addMapping("Walk Backward",new KeyTrigger(KeyInput.KEY_DOWN));
	}
  
	private static void setupKeys(boolean first, int left, int right, int forward, int backward, int jump) 
	{
		
		getInputManager().addMapping("Walk Forward",new KeyTrigger(forward));
		getInputManager().addMapping("Walk Backward",new KeyTrigger(backward));
		getInputManager().addMapping("Jump", new KeyTrigger(jump));
		
		if (first){
			getInputManager().addMapping("Strafe Left", new KeyTrigger(left));
			getInputManager().addMapping("Strafe Right",new KeyTrigger(right));
			getInputManager().addListener(GVars_GJ.actionLisen, "Strafe Left", "Strafe Right");
		}else{
			getInputManager().addMapping("Rotate Left",new KeyTrigger(left));
			getInputManager().addMapping("Rotate Right",new KeyTrigger(right));
			getInputManager().addListener(GVars_GJ.actionLisen, "Rotate Left", "Rotate Right");
		}
		
		getInputManager().addListener(GVars_GJ.actionLisen, "Walk Forward", "Walk Backward");
		getInputManager().addListener(GVars_GJ.actionLisen, "Jump");
	  }
  
    private static InputManager getInputManager() 
    {return GVars_GJ.app.getInputManager() ; }
	
	
}
