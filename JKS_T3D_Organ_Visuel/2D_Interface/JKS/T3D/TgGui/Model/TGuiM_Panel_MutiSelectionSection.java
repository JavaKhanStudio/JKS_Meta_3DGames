package JKS.T3D.TgGui.Model;

import com.jme3.math.Vector2f;

import JKS.T3D.TgGui.Utils.Utils_ToneGod;
import tonegod.gui.controls.buttons.RadioButton;
import tonegod.gui.controls.buttons.RadioButtonGroup;
import tonegod.gui.controls.windows.Panel;
import tonegod.gui.core.ElementManager;

public class TGuiM_Panel_MutiSelectionSection extends Panel
{
	
	protected Panel radioPanel ;
	protected Panel contentPanel ;
	protected RadioButtonGroup group ;
	
	float hauteurBarre ;
	float radioSizeX  ;
	float radioSizeY  ;
	
	int decalX = 4 ;
	int decalY = 4 ; 
	protected float blockSizeX  ;
	float textSizeY = 28; 

	public TGuiM_Panel_MutiSelectionSection(int colum,int row ,Vector2f size,ElementManager screen) 
	{
		super(screen);
		this.setDimensions(size);
		
		blockSizeX = (this.getWidth()/colum) - decalY*(colum + 1) ; 
		radioSizeX = blockSizeX/5 ; 
		radioSizeY = radioSizeX ; 
		textSizeY = radioSizeY ;
		
		
		hauteurBarre = row * radioSizeY + decalY*(row + 1);
		
		radioPanel = new Panel
		(
			screen,
			new Vector2f(0,0), // position
			new Vector2f(this.getWidth(), hauteurBarre) // size
		) ;
		
		radioPanel.setIsMovable(false);
		radioPanel.setIsResizable(false);
		radioPanel.setIgnoreMouse(true);
				
		contentPanel = new Panel
		(
			 screen,
			 new Vector2f(0,radioPanel.getHeight()),
			 new Vector2f(this.getWidth(),this.getHeight() - radioPanel.getHeight())
		) ;
				 
		 contentPanel.setAsContainerOnly();
		 
		 this.addChild(radioPanel);
		 this.addChild(contentPanel);
	}
	
	protected void buildRadio(int posX,int posY, String panelName)
	{
		RadioButton radioButton = new RadioButton(
				screen,
				new Vector2f((blockSizeX + decalX)*posX + decalX,(decalY + radioSizeY) * posY + decalY),
				new Vector2f(radioSizeX,radioSizeY)
				) ;
		
		radioButton.setUserData("radio", panelName);
		
		Utils_ToneGod.addLabelOnTheRight(radioButton, panelName);
		radioButton.setIsChecked(true);
		
		group.addButton(radioButton);
		radioPanel.addChild(radioButton);
	}
	
	protected void changeSelect(Panel infoMapBar) 
	{
		contentPanel.removeAllChildren(); ; 
		contentPanel.addChild(infoMapBar);
	}

	
	
	
}
