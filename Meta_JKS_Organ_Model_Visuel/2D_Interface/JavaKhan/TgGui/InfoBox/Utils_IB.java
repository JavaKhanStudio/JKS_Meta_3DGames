package JavaKhan.TgGui.InfoBox;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.TgGui.Utils.Utils_ToneGod;

public class Utils_IB 
{
	public static void setIm(IB_AInfoBox_Model model)
	{
		if(GVars_Soul_Model.infoBox != null)
			{Utils_ToneGod.safeRemove(GVars_Soul_Model.infoBox);}
		
		GVars_Soul_Model.infoBox = model ; 
		Utils_ToneGod.safeAdd(GVars_Soul_Model.infoBox);
	}

	public static void clear() 
	{
		if(GVars_Soul_Model.infoBox != null)
			{Utils_ToneGod.safeRemove(GVars_Soul_Model.infoBox);}
	}
}
