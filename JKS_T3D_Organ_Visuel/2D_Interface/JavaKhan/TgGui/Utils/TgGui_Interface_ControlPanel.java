package JavaKhan.TgGui.Utils;

import com.jme3.scene.Spatial;

public interface TgGui_Interface_ControlPanel
{
	
	// REMEMBER TOO ADD THIS SHIT IN THE CONTROL ZONE
	// ME_Admin_ControlFrame
	
	final int decalX = 5 ;
	final int decalY = 5 ;
	
	public abstract String getPanelPartName() ; 
	
	public default void clickAction(Spatial s, boolean left)
	{System.out.println("Rien a faire sur un click de " + getPanelPartName()) ;}
	
	public default void onLeaving()
	{}
	
//	public default ArrayList<Enum_Editor_IntePossible> getPossibleInte()
//	{
//		return new ArrayList() ;
//	}
	
}
