package JKS.T3D.test;

import com.jme3.app.SimpleApplication;
import com.jme3.input.FlyByCamera;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.shadow.DirectionalLightShadowFilter;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.system.AppSettings;

import JKS.T3D.GVE.Apply.Utils_GVE;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Utils.Model3D.Utils_3DObject;
import JKS.T3D.test.Utils.Utils_Test;

public class Test_Shadow extends SimpleApplication
{

	protected static FlyByCamera flyCam;
	DirectionalLight sun ;
	
    public static final int SHADOWMAP_SIZE = 1024;
    
    public static DirectionalLightShadowRenderer dlsr;
    public static DirectionalLightShadowFilter dlsf;
    
	public static void main(String[] args) 
	{
		  Test_Shadow app = new Test_Shadow();
		    AppSettings newSetting = new AppSettings(true);
			newSetting.setFrameRate(60);
			newSetting.setResolution(1280,960);
			app.setDisplayStatView(false);
			app.setSettings(newSetting) ;
			app.setShowSettings(false);
		    app.start();
	}
	
	@Override
	public void simpleInitApp() 
	{
		GVars_Soul_Model.initTheSoul(this);
		Utils_GVE.initFilters(this);
		
		flyCam = new FlyByCamera(cam);
		flyCam.setEnabled(true);
		flyCam.setMoveSpeed(0);
		flyCam.setZoomSpeed(100);
		
		cam.setLocation(new Vector3f(5,15,5));
		cam.lookAt(new Vector3f(100,100,100), Vector3f.ZERO);
		cam.setFrustumFar(5000) ;
		cam.lookAt(buildTestMap().getLocalTranslation(), Vector3f.ZERO); ;
		
		Utils_Test.buildLights();
		buildTestMap() ; 
	}
	

	
	public static Spatial buildTestMap()
	{
		Utils_Test.addABox(new Vector3f(100,1,100),new Vector3f(0,0,0),ColorRGBA.White) ; 
	        
		return Utils_Test.addABox(new Vector3f(1,1,1),new Vector3f(0,10,0),ColorRGBA.Blue) ; 
	}

	
	
}
