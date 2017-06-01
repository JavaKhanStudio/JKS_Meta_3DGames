package JavaKhan.TgGui.Model;

import com.jme3.math.Vector2f;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.TgGui.Utils.Utils_ToneGod;
import tonegod.gui.controls.text.Label;
import tonegod.gui.core.ElementManager;

public class TGuiM_Label_CleanText extends Label
{

	static final float multSize = 2.0f ;
	
	
	public TGuiM_Label_CleanText(ElementManager screen, Vector2f position, Vector2f dimensions) 
	{
		super(screen, position, dimensions);
		Utils_ToneGod.cleanEveryEffect(this);
		this.setIgnoreMouse(true);
	}
	
	public TGuiM_Label_CleanText(Vector2f position, float sizeY,String text)
	{this(GVars_Soul_Model.screen,position,sizeY,text) ;}
	
	public TGuiM_Label_CleanText(ElementManager screen, 
							Vector2f position, 
							float sizeY,
							String text) 
	{
		super(GVars_Soul_Model.screen, position, new Vector2f());
		this.setFontSize(sizeY);
		this.setText(text);
		Utils_ToneGod.setCutSize(this);
		Utils_ToneGod.cleanEveryEffect(this);
		this.setIgnoreMouse(true);
		
		
		this.setText(text);
	}
	
	

}

