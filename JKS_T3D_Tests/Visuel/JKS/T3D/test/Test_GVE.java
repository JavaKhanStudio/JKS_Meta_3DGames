package JKS.T3D.test;

import com.jme3.app.SimpleApplication;
import com.jme3.input.FlyByCamera;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;

import JKS.T3D.GVE.Apply.Utils_GVE;
import JKS.T3D.GVE.Filtre.Utils_OutilineFilter;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Map.GE.Filter.GE_LakeWater;
import JKS.T3D.Utils.Model3D.Utils_3DObject;

public class Test_GVE extends SimpleApplication
{

	protected static FlyByCamera flyCam;
	
	  public static void main(String[] args) 
	  {
		  Test_GVE app = new Test_GVE();
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
		
		cam.setLocation(new Vector3f(1000,800,100));
		cam.lookAt(new Vector3f(100,100,100), Vector3f.ZERO);
		
		Node currentStage = (Node) Utils_3DObject.safeGetSpatial("JKS/testAsset/map/GMOD_Stage_1_V2.j3o") ; 
		currentStage.scale(5) ; 
		
		Utils_3DObject.safeAdd(currentStage);
		this.initLight();
		
		Utils_GVE.initFilters(this);
		
	    GE_LakeWater lakeWater = new GE_LakeWater(320) ; 
	    Utils_GVE.ApplyFilter(lakeWater);
	    
		Utils_OutilineFilter.initFilter();
		Utils_OutilineFilter.showOutlineEffect(currentStage, 1, ColorRGBA.White);
	}
	
	
	public void initLight()
	{
		AmbientLight ambientLight = new AmbientLight();
		ambientLight.setColor(new ColorRGBA(1, 1, 1, 0.5f));
		this.getRootNode().addLight(ambientLight);
		
		DirectionalLight sun = new DirectionalLight();
		sun.setColor(new ColorRGBA(1, 1, 1, 0.5f));
		this.getRootNode().addLight(sun);	
	}
}
