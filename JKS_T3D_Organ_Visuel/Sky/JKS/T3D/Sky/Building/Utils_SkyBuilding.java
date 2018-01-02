package JKS.T3D.Sky.Building;

import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.shadow.DirectionalLightShadowFilter;

import JKS.T3D.GVE.Apply.Utils_GVE;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import jme3utilities.sky.SkyControl;

public class Utils_SkyBuilding 
{

	public static SkyControl buildBasic()
	{
		AmbientLight ambientLight = new AmbientLight();
		ambientLight.setColor(ColorRGBA.White);
		GVars_Soul_Model.app.getRootNode().addLight(ambientLight);
		
		DirectionalLight sun = new DirectionalLight();
		GVars_Soul_Model.app.getRootNode().addLight(sun);
		
		boolean starMotion = true;
	    boolean bottomDome = true;
	    SkyControl skyControl = new SkyControl(
	    		GVars_Soul_Model.app.getAssetManager(), GVars_Soul_Model.app.getCamera(), 0.9f, starMotion, bottomDome);
	    GVars_Soul_Model.app.getRootNode().addControl(skyControl);
	    skyControl.getUpdater().setMainLight(sun);
	    skyControl.getUpdater().setAmbientLight(ambientLight);
	    skyControl.getSunAndStars().setHour(12);
	    skyControl.getSunAndStars().setObserverLatitude(0.9f);
	    skyControl.setCloudiness(0.8f);
	    
	    skyControl.setEnabled(true);
	    
	    new TA_SkyHeart(skyControl) ; 
	    
	    return skyControl ; 
	}
	
//	public static SkyControl buildMock()
//	{
//		SkyControl returning = buildBasic() ; 
//		
//	}
	
	
	
}
