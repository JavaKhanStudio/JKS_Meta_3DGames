package JKS_Head.GVars;

import com.jme3.app.SimpleApplication;

import tonegod.gui.core.Screen;

public interface basicImpl 
{
	
	public default SimpleApplication getApp()
	{return GVars_Soul_Model.getApp();}
	
	public default Screen getScreen()
	{return GVars_Soul_Model.getScreen();}
}
