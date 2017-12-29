package JavaKhan.TgGui.Model.Dialogue;

import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.math.Vector2f;

import tonegod.gui.controls.buttons.Button;
import tonegod.gui.core.ElementManager;

public class Dialogue_Option extends Button
{

	public Dialogue_Option(ElementManager screen, String UID, Vector2f position, Vector2f dimensions) 
	{
		super(screen, UID, position, dimensions);
		
		
		
	}

	@Override
	public void onButtonMouseLeftDown(MouseButtonEvent evt, boolean toggled) 
	{
		System.out.println("") ; 
		
	}

	@Override
	public void onButtonMouseRightDown(MouseButtonEvent evt, boolean toggled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onButtonMouseRightUp(MouseButtonEvent evt, boolean toggled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onButtonFocus(MouseMotionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onButtonLostFocus(MouseMotionEvent evt) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
