package CollisionEvent;

import JavaKhan.Son.Controler.Utils_Sound;

public class DialogueApply 
{

	public static final String diaPath = "Sounds/Dialogue/" ; 
	
	public static void actOnIt(String path)
	{
		String lecture = diaPath + path ;
		Utils_Sound.makeASound(lecture, 20);
	}
	
	
}
