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
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

import JKS.T3D.Camera.Init_Camera;
import JKS.T3D.Clavier.Control_Clavier;
import JKS.T3D.Clavier.Utils_Clavier_GJ;
import JKS.T3D.Data.Charac_Main;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.M3DV.ThreadedAction.BulletAppSpaceAddOn.TA_Trampoline;
import JKS.T3D.Utils.Model3D.Utils_3DObject;
import JKS.T3D.test.Utils.Utils_Test;
import MovementControl.AppS_Chacter_Move; 

public class Test_Character extends SimpleApplication
{

	public static BulletAppState bulletAppState; 
	
	public static void main(String[] args) 
	  {
		Test_Character app = new Test_Character();
		    AppSettings newSetting = new AppSettings(true);
			newSetting.setFrameRate(60);
//			newSetting.setResolution(1280,960);
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
		Charac_Main.physicsCharacter.warp(new Vector3f(0,3,0));
		
		GVars_Soul_Model.actionLisen = new Control_Clavier() ; 
		Utils_Clavier_GJ.setupKeysId(10,true);
	    
	    Init_Camera.BuildCamera(Charac_Main.visualCharacter);
        Init_Camera.initCameraThirdPerson();
//	    Init_Camera.initCameraThirdPersonFromHigh();
        
        Spatial geom = Utils_Test.addABox(new Vector3f(2, 2, 2), Vector3f.ZERO.add(0, 1, 0), ColorRGBA.Red) ;
	    geom.addControl(new RigidBodyControl(0));
        bulletAppState.getPhysicsSpace().add(geom);
        
        addAFloor(); 

        GVars_Soul_Model.app.getStateManager().attach(new AppS_Chacter_Move(Charac_Main.physicsCharacter)) ;
	}

	public static void addAFloor()
	{
		Spatial geom = Utils_Test.addABox(new Vector3f(100, 1, 100), Vector3f.ZERO, ColorRGBA.White) ;
	    geom.addControl(new RigidBodyControl(0));
        bulletAppState.getPhysicsSpace().add(geom);
        geom.setUserData("Event", "Gravity");
        geom.setUserData("Gravity", "true");
		
		
		Spatial geom2 = Utils_Test.addABox(new Vector3f(100, 1, 100), new Vector3f(0,30,0), ColorRGBA.Blue) ;
		geom2.addControl(new RigidBodyControl(0));
		bulletAppState.getPhysicsSpace().add(geom2);
//		geom2.setUserData("Event", "Gravity");
//	    geom2.setUserData("Gravity", "false");
	}
	
	public static void addABox()
	{
	    Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);
        geom.setLocalTranslation(0, 10, 0);
        geom.setShadowMode(ShadowMode.CastAndReceive);
        
        Material mat = new Material(GVars_Soul_Model.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);
        
        geom.addControl(new RigidBodyControl(0));
        bulletAppState.getPhysicsSpace().add(geom);
        Utils_3DObject.safeAdd(geom);
        new TA_Trampoline(2, geom, bulletAppState) ;
	}
}
