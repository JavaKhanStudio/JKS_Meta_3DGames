package JavaKhan.TgGui.Interfaces;

import com.jme3.input.event.MouseMotionEvent;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.TgGui.InfoBox.IB_AInfoBox_Model;
import JavaKhan.TgGui.InfoBox.Utils_IB;
import JavaKhan.TgGui.Utils.Utils_ToneGod;
import tonegod.gui.listeners.MouseFocusListener;

public interface TgGui_Interface_LookMeOrIB extends MouseFocusListener
{

	@Override
	public default void onGetFocus(MouseMotionEvent evt) 
	{focusAction(evt) ; }

	@Override
	public default void onLoseFocus(MouseMotionEvent evt) 
	{loseFocusAction(evt) ;}
	
	public default void focusAction(MouseMotionEvent evt) 
	{
		try
		{Utils_IB.setIm(getIbType()) ;}
		catch(Exception e)
		{e.printStackTrace();}
	}
	
	public default void loseFocusAction(MouseMotionEvent evt) 
	{
		if(GVars_Soul_Model.infoBox != null)
			Utils_ToneGod.safeRemove(GVars_Soul_Model.infoBox);
	}
	
	
	
	public IB_AInfoBox_Model getIbType() ; 
}
