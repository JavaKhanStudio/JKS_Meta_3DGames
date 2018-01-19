package JKS.T3D.test;

import static JKS.T3D.test.Utils.Utils_Test.buildLights;
import static JKS.T3D.test.Utils.Utils_Test.initCarac;
import static JKS.T3D.test.Utils.Utils_Test.initPhysic;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

import JKS.T3D.Camera.Init_Camera;
import JKS.T3D.Clavier.Control_Clavier;
import JKS.T3D.Clavier.Utils_Clavier_GJ;
import JKS.T3D.Data.Charac_Main;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Utils.Model3D.Utils_3DObject;
import JKS.T3D.test.Utils.Utils_Test;
import MovementControl.AppS_Chacter_Move;

public class Test_Character_Camera  extends SimpleApplication
{

	public static BulletAppState bulletAppState; 
	
	public static void main(String[] args) 
	{
		Test_Character_Camera app = new Test_Character_Camera();
	    AppSettings newSetting = new AppSettings(true);
		newSetting.setFrameRate(60);
//		newSetting.setResolution(1280,960);
		newSetting.setResolution(500,500);
		app.setDisplayStatView(false);
		app.setSettings(newSetting) ;
		app.setShowSettings(false);
	    app.start();
	}
	

	@Override
	public void simpleInitApp() 
	{
		GVars_Soul_Model.initTheSoul(this);
		Logger.getLogger("").setLevel(Level.SEVERE);
		bulletAppState = initPhysic() ; 
		buildLights() ;
		
		initCarac(bulletAppState) ; 
		
		GVars_Soul_Model.actionLisen = new Control_Clavier() ; 
		Utils_Clavier_GJ.setupKeysId(10,true);
	    
	    Init_Camera.BuildCamera(Charac_Main.visualCharacter);
        Init_Camera.initCameraThirdPersonFromHigh();

        addABox() ; 
        
        Utils_Test.addABox(new Vector3f(2,2,2),new Vector3f(15,4,15),ColorRGBA.Red) ; 
        Utils_Test.addABox(new Vector3f(2,2,2),new Vector3f(15,4,0),ColorRGBA.Green) ; 
        Utils_Test.addABox(new Vector3f(1,1,1),new Vector3f(0,4,15),ColorRGBA.Yellow) ; 
        
//        Utils_Test.addABox(new Vector3f(1,1,1),new Vector3f(0,4,0),ColorRGBA.Yellow) ; 
        Utils_Test.addABox(new Vector3f(1,1,1),new Vector3f(5,4,5),ColorRGBA.Yellow) ; 
        Utils_Test.addABox(new Vector3f(1,1,1),new Vector3f(0,4,5),ColorRGBA.Yellow) ; 

        GVars_Soul_Model.app.getStateManager().attach(new AppS_Chacter_Move(Charac_Main.physicsCharacter)) ;
	}

	public static void addABox()
	{
	    Box b = new Box(100, 1, 100);
        Geometry geom = new Geometry("Box", b);

//        geom.setUserData("Event", "SwitchCam");
//        geom.setUserData("SwitchCam", "Cam_P3");
        Material mat = new Material(GVars_Soul_Model.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);
        
        geom.addControl(new RigidBodyControl(0));
        bulletAppState.getPhysicsSpace().add(geom);
        Utils_3DObject.safeAdd(geom);
	}
}