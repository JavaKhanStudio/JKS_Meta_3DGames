package Camera;

import java.util.ArrayList;

import com.jme3.app.SimpleApplication;
import com.jme3.input.ChaseCamera;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;

import JKS_Head.GVars.GVars_Soul_Model;

public class Settings_Camera 
{
	static Camera cam ; 
	static SimpleApplication app ;
	static int count = 0 ; 
	public static ArrayList<Quaternion> cameraList ; 
	public static ArrayList<Vector3f> deplacement ; 
	
	public static final float cameraDistance = 80f ;
	public static float hauteur = 45 ; 
	public static ChaseCamera chaseCam ;
	
	public static boolean normalState ;
	public static boolean fromTopState ;
	public static boolean fromSideState ;
	
	public Settings_Camera(SimpleApplication App)
	{
		app = App ;
		cameraList = new ArrayList<Quaternion>() ;
		deplacement = new ArrayList<Vector3f>() ;
		
		deplacement.add(new Vector3f(10f,hauteur,0f)) ; 
		cameraList.add(new Quaternion(0.31212112f, -0.30f, 0.10658956f, 0.90f)) ;
		deplacement.add(new Vector3f(10f,10f,0f)) ; 
		cameraList.add(new Quaternion(0.47413063f, -0.30f, 0.16010809f, 0.90f)) ;
		deplacement.add(new Vector3f(-20f,-20f,0f)) ; 
		cameraList.add(new Quaternion(0.20226645f, -0.30f, 0.06940503f, 0.90f)) ; 
	}
	

	

	public static void initCam()
	
	{
		
		cam = GVars_Soul_Model.app.getCamera() ;
		cam.setLocation(new Vector3f(0f, cameraDistance,5f));
		cam.lookAt(new Vector3f(0,0,0), new Vector3f(5,5,5));
		cam.setFrustumFar(5000) ;
		
	}
	
	
	
	public static void nextModel()
	{
		count ++ ; 
		if(count == cameraList.size())
		{count = 0 ;}
		
		cam.setAxes(new Quaternion(
				cameraList.get(count).getX(),
				cam.getRotation().getY(),
				cameraList.get(count).getZ(),
				cam.getRotation().getW()));
	
		cam.setLocation(cam.getLocation().add(deplacement.get(count)));
	}
	
	public static void initLight()
	{
		AmbientLight al = new AmbientLight();
	    al.setColor(ColorRGBA.White.mult(.6f));
	    GVars_Soul_Model.app.getRootNode().addLight(al);
	 
		DirectionalLight sun = new DirectionalLight();
        sun.setColor(ColorRGBA.White.mult(.8f));
        sun.setDirection(GVars_Soul_Model.app.getCamera().getDirection());
        GVars_Soul_Model.app.getRootNode().addLight(sun);
	}
	}

/*
public static void nextModel()
{
	System.out.println("Testing");
	count ++ ; 
	if(count == cameraList.size())
	{count = 0 ;}
	cam.setAxes(cameraList.get(count));
	cam.setAxes(new Quaternion(
			cameraList.get(count).getX(),
			cam.getRotation().getY(),
			cameraList.get(count).getZ(),
			cam.getRotation().getW()));
	cam.setLocation(cam.getLocation().add(deplacement.get(count)));

}
*/