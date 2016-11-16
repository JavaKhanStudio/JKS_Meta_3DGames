package JKS_Head.GVars;

import com.jme3.app.SimpleApplication;
import com.jme3.input.controls.ActionListener;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;

import tonegod.gui.core.Screen;

public class GVars_Soul_Model 
{

	public static SimpleApplication app ;
	public static Screen screen ;
	
	
	public static ActionListener actionLisen ;
	public static boolean showLogs = true ;
	
	public static void initTheSoul(SimpleApplication App)
	{
		app = App ; 
		screen = new Screen(app) ; 
		app.getGuiNode().addControl(screen);
	}


	public static SimpleApplication getApp()
	{return app ;}
	
	public static Screen getScreen()
	{return screen ;}

	public static Node getRootNode() 
	{return app.getRootNode();}
	
	public static Camera getCam()
	{return app.getCamera();}
	
	
}
