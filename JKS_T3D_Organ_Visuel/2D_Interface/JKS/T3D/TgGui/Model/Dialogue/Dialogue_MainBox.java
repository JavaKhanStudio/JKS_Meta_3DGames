package JKS.T3D.TgGui.Model.Dialogue;

import java.util.ArrayList;

import com.jme3.math.ColorRGBA;

import JKS.T3D.Dialogue.Segment.D1_Dialogue_Message;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import tonegod.gui.controls.buttons.Button;
import tonegod.gui.controls.windows.Panel;

public class Dialogue_MainBox extends Panel
{

	public D1_Dialogue_Message currentDialogue ; 
	
	public Dialogue_MainBox() 
	{
		super(GVars_Soul_Model.screen);
		
		this.setWidth(this.screen.getWidth());
		this.setHeight(200);
		this.setColor(ColorRGBA.Cyan);
		this.setPosition(0, screen.getHeight() - this.getHeight());
		screen.addElement(this);
	}

	public void openConversation()
	{
		this.setIsVisible(true);
	}

	public void closeConversation() 
	{
		this.setIsVisible(false);
	}

	public void addOptionList(ArrayList<Button> list) 
	{
		for(Button button : list)
		{
			this.addChild(button);
		}
		
		
	}

	
	
}
