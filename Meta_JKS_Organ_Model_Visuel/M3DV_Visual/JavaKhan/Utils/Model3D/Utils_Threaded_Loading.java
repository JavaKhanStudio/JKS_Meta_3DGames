package JavaKhan.Utils.Model3D;

import com.jme3.scene.Spatial;

import JKS_Head.GVars.GVars_Soul_Model;

public class Utils_Threaded_Loading extends Thread
{
	
	String path ;
	Spatial spa ; 
	public Utils_Threaded_Loading(String Path)
	{
		path = Path ;
		this.start();
	}
	
	public void run()
	{
//		if(GVars_Soul_Model.showLogs)
//			System.out.println("[Client] " + path);
		
		try
		{GVars_Soul_Model.app.getAssetManager().loadAsset(path) ;}
		catch(Exception e)
		{
			//System.out.println("[Client] : Impossible de loader " + path);
			//e.printStackTrace();
		}
		
	}
	

}