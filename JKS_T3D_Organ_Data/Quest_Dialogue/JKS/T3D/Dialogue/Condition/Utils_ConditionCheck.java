package JKS.T3D.Dialogue.Condition;

import JKS.T3D.Utils.Logger.Utils_Logger;

public class Utils_ConditionCheck 
{

	public static boolean respectCondition(Enum_ConditionType condiType)
	{
		switch (condiType)
		{
			case LEVEL :
				System.out.println("Mondays are bad.");
				break ; 
			case QUEST_DONE :
				
				break ; 
			default :
				Utils_Logger.logError("Utils_ConditionCheck", "Impossible de trouver " + condiType);
		}
		return false ; 
	}
	
	
}
