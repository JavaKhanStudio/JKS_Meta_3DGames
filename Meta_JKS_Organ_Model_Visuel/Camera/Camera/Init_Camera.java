package Camera;

import com.jme3.math.Vector3f;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Node;
import com.jme3.scene.control.CameraControl.ControlDirection;


import JKS_Head.GVars.GVars_Soul_Model;

public class Init_Camera 
{
	
	static CameraNode camNode;
	static Node charac  ;
	static Node stage ; 
	
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
		camNode.setLocalTranslation(new Vector3f(0, 30, -60));
		camNode.lookAt(charac.getLocalTranslation(), Vector3f.UNIT_Y);
	}
	
	public static void initCameraThirdPersonClose()
	{
		controlCam(Enum_CamType.THIRD_PERSON);
		int yView = 14 ;
	    camNode.setLocalTranslation(new Vector3f(0,yView, -10));
	    camNode.lookAt(charac.getLocalTranslation().add(0, yView, 0), Vector3f.UNIT_Y);
	}
	
	public static void initCameraThirdPersonFromHigh()
	{
		controlCam(Enum_CamType.THIRD_PERSON_TOP);
		camNode.setLocalTranslation(new Vector3f(0, 100, 0));
		camNode.lookAt(charac.getLocalTranslation(), Vector3f.UNIT_Y);
	}
	
	public static void initCameraFirstPerson()
	{
		controlCam(Enum_CamType.FIRST_PERSON);
		camNode.setLocalTranslation(new Vector3f(0, 15, 0));
	}

	public static void initCameraThirdPersonFromSide(String num) 
	{
		controlCam(Enum_CamType.THIRD_PERSON_SIDE) ;
		
	    camNode.getCamera().setLocation(((Node) stage.getChild("Cameras")).getChild("Camera2D_out_" + num).getWorldTranslation());
	    camNode.getCamera().lookAt(((Node) stage.getChild("Cameras")).getChild("Camera2D_in_" + num).getWorldTranslation(), Vector3f.UNIT_Y);
	}
	
	
	
	public static void controlCam(Enum_CamType attach)
	{
		Settings_Camera.fromSideState = false ;
		Settings_Camera.fromTopState = false ; 
		Settings_Camera.normalState = false ;
		
		
		switch(attach)
		{
			case FIRST_PERSON :
			{
				//GVars_GJ.getApp().getFlyByCamera().setEnabled(true);
				shouldDetatchCam(false) ;
				Settings_Camera.normalState = true ;
				break ; 
			}
			case THIRD_PERSON :
			{
				//GVars_GJ.getApp().getFlyByCamera().setEnabled(true);
				shouldDetatchCam(false) ;
				Settings_Camera.normalState = true ;
				break ;
			}
			case THIRD_PERSON_SIDE :
			{
				//GVars_GJ.getApp().getFlyByCamera().setEnabled(false);
				shouldDetatchCam(true) ;
				Settings_Camera.fromSideState = true ;
				break ; 
			}
			case THIRD_PERSON_TOP :
			{
				//GVars_GJ.getApp().getFlyByCamera().setEnabled(false);
				shouldDetatchCam(false) ;
				Settings_Camera.fromTopState = true ; 
				break ; 
			}
		}
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
}
