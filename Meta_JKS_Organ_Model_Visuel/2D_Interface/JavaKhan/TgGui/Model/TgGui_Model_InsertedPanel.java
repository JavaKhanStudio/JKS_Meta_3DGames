package JavaKhan.TgGui.Model;

import com.jme3.math.Vector2f;

import JKS_Head.GVars.GVars_Soul_Model;
import tonegod.gui.controls.windows.Panel;

public class TgGui_Model_InsertedPanel extends Panel
{

	public TgGui_Model_InsertedPanel(Panel pan) 
	{
		super(GVars_Soul_Model.screen,
				new Vector2f(0,0),
				new Vector2f(pan.getWidth(),pan.getHeight())
				);
		
		
		this.setIsResizable(false);
		this.setAsContainerOnly();
		this.setIsMovable(false);
	}
	
}