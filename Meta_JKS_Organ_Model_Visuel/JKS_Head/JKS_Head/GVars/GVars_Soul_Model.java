package JKS_Head.GVars;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;

import Camera.Enum_CamType;
import JavaKhan.TgGui.InfoBox.IB_AInfoBox_Model;
import tonegod.gui.core.Screen;

public abstract class GVars_Soul_Model 
{

	public static SimpleApplication app ;
	public static Screen screen ;
	public static Enum_CamType currentCam ;
	public static IB_AInfoBox_Model infoBox ; 
	
	public static ActionListener actionLisen ;
	public static boolean showLogs = true ;
	
	public static void initTheSoul(SimpleApplication App)
	{
		app = App ; 
		screen = new Screen(app) ; 
		app.getGuiNode().addControl(screen);
	}
	
	
	protected abstract void personalInit() ;
	
	public static AssetManager getAssetManager()
	{return app.getAssetManager();}


	public static SimpleApplication getApp()
	{return app ;}
	
	public static Screen getScreen()
	{return screen ;}

	public static Node getRootNode() 
	{return app.getRootNode();}
	
	public static Camera getCam()
	{return app.getCamera();}
	
	
}
