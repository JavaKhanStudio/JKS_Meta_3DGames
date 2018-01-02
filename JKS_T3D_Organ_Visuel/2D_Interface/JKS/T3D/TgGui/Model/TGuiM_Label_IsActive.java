package JKS.T3D.TgGui.Model;

import com.jme3.math.Vector2f;

import JKS.T3D.GVE.GVars.FVars_Path2D;
import JKS.T3D.TgGui.Utils.Utils_ToneGod;
import tonegod.gui.controls.text.Label;
import tonegod.gui.controls.windows.Panel;

public class TGuiM_Label_IsActive extends Label
{
	static int sizeX = 40 ; 
	static int sizeY = sizeX ;
	
	static int decalX = 5; 
	static int decalY = 5;
	
	public TGuiM_Label_IsActive(Panel into) 
	{
		super(into.getScreen(), new Vector2f(into.getDimensions().x - sizeX - decalX - (sizeX * 8),decalY), new Vector2f(sizeX,sizeY));
		Utils_ToneGod.addLabelOnTheRight(this, "Is Active?");
	}
	public void setIsActive(boolean isIt)
	{
		if(isIt)
		{this.setColorMap(FVars_Path2D.serverImage + "cGreen.png");}
		else
		{this.setColorMap(FVars_Path2D.serverImage + "cRed.png");}
	}
	
	
	
}
