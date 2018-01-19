package JKS.T3D.Camera;

import com.jme3.input.ChaseCamera;
import com.jme3.input.controls.AnalogListener;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Node;
import com.jme3.scene.control.CameraControl.ControlDirection;
import com.jme3.util.TempVars;

import JKS.T3D.Head.GVars.GVars_Soul_Model;

public class Init_Camera 
{
	
	static CameraNode camNode;
	static Node charac  ;
	static Node stage ;
	static AnalogListener analogLisen; 
	
	public static void BuildCamera(Node Charac)
	{
		camNode = new CameraNode("CamNode", GVars_Soul_Model.app.getCamera());
	    camNode.setControlDir(ControlDirection.SpatialToCamera);
	    charac = Charac ;
	    charac.attachChild(camNode);
	}
	
	public static void BuildCamera(Node Charac, Node Stage)
	{
		camNode = new CameraNode("CamNode", GVars_Soul_Model.app.getCamera());
	    camNode.setControlDir(ControlDirection.SpatialToCamera);
	    charac = Charac ;
	    stage = Stage; 
	    charac.attachChild(camNode);
	}
	
	public static void initCameraThirdPerson()
	{
		controlCam(Enum_CamType.THIRD_PERSON);
		camNode.setLocalTranslation(new Vector3f(0, 15, -20));
		lookAt(charac.getLocalTranslation().add(0, 0, 50));
	}
	
	public static void initCameraThirdPersonClose()
	{
		controlCam(Enum_CamType.THIRD_PERSON);
		int yView = 14 ;
	    camNode.setLocalTranslation(new Vector3f(0,yView, -10));
	    lookAt(charac.getLocalTranslation().add(0, yView, 0));
	}
	
	public static void initCameraThirdPersonFromHigh()
	{
		controlCam(Enum_CamType.THIRD_PERSON_TOP);
		
		
//		camNode.setLocalRotation(Quaternion.ZERO);
		camNode.setLocalTranslation(0, 0, 0);
		
		camNode.getCamera().setLocation(charac.getLocalTranslation().add(0, 40, 0));
//		camNode.getCamera().setRotation(Quaternion.ZERO);
		camNode.getCamera().lookAt(charac.getLocalTranslation(), Vector3f.UNIT_Y);
		
		buildChaseCam() ; 
		
		
		System.out.println(camNode.getCamera().getRotation());
	}
	
	public static void initCameraFirstPerson()
	{
		controlCam(Enum_CamType.FIRST_PERSON);
		camNode.setLocalTranslation(new Vector3f(0, 15, 0));
	}

	public static void initCameraThirdPersonFromSide(String num) 
	{
		if(stage == null)
		{System.out.println("Need a stage!");}
		
		controlCam(Enum_CamType.THIRD_PERSON_SIDE) ;
		
	    camNode.getCamera().setLocation(((Node) stage.getChild("Cameras")).getChild("Camera2D_out_" + num).getWorldTranslation());
	    camNode.getCamera().lookAt(((Node) stage.getChild("Cameras")).getChild("Camera2D_in_" + num).getWorldTranslation(), Vector3f.UNIT_Y);
	}
	
	
	public static void lookAt(Vector3f position)
	{
		Vector3f worldTranslation = camNode.getWorldTranslation();
        TempVars vars = TempVars.get();

        Vector3f compVecA = vars.vect4;
        compVecA.set(position).subtractLocal(worldTranslation);
        
        TempVars vars2 = TempVars.get();
        vars2.vect3.set(compVecA).normalizeLocal();
        vars2.vect1.set(Vector3f.ZERO).crossLocal(compVecA).normalizeLocal();
        vars2.vect2.set(compVecA).crossLocal(vars2.vect1).normalizeLocal();
        vars2.release();

        vars.release();
	}
	
	
	public static void controlCam(Enum_CamType attach)
	{
		
		Settings_Camera.currentCamType = attach ; 
				
		switch(attach)
		{
			case FIRST_PERSON :
			case THIRD_PERSON :
			{
				GVars_Soul_Model.getApp().getFlyByCamera().setEnabled(true);
				GVars_Soul_Model.getApp().getInputManager().setCursorVisible(false);
				shouldDetatchCam(false) ;
				break ;
			}
			case THIRD_PERSON_SIDE :
			{
				GVars_Soul_Model.getApp().getFlyByCamera().setEnabled(false);
				GVars_Soul_Model.getApp().getInputManager().setCursorVisible(false);
				shouldDetatchCam(true) ;
				break ; 
			}
			case THIRD_PERSON_TOP :
			{
				GVars_Soul_Model.getApp().getFlyByCamera().setEnabled(false);
				GVars_Soul_Model.getApp().getInputManager().setCursorVisible(true);
				shouldDetatchCam(true) ;
				break ; 
			}
		}
	}
	
	private static void buildChaseCam() 
	{
		ChaseCamera chaseCam = new ChaseCamera(camNode.getCamera(), charac, GVars_Soul_Model.app.getInputManager());
		chaseCam.setMaxDistance(30);
		chaseCam.setMinDistance(30);
		chaseCam.setDefaultVerticalRotation(1.5708f);
//		chaseCam.setDefaultHorizontalRotation(1.5708f);
		chaseCam.setTrailingEnabled(true) ;
		chaseCam.setToggleRotationTrigger() ;
	}

	public static void shouldDetatchCam(boolean should)
	{
		if(charac.hasChild(camNode))
		{
			if(should)
			{charac.detachChild(camNode);}
		}
		else
		{
			if(!should)
			{charac.attachChild(camNode);}
		}
	}
	
	public static Camera getCamera()
	{return camNode.getCamera() ;}
}
