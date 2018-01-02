package JKS.T3D.Keys.Control;

import com.jme3.input.controls.InputListener;

import JKS.T3D.Head.GVars.GVars_Soul_Model;

public interface Keys_Model 
{

	public void initKeys() ;
	
	public InputListener getInputListener() ; 
	
	public default void dettach() 
	{GVars_Soul_Model.getApp().getInputManager().removeListener(getInputListener()) ;}
	
}
