package JKS.T3D.M3DV.ThreadedAction;

import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

public class TA_Push extends  AbstractControl 
{

	int targetPosX ; 
	int targetPosY ; 
	
	float speed = 26f ; 
	boolean cutIn = false ; 
	double see ; 
	float i = 0 ; 
	float targetX ;
	float targetZ ; 
	float timmer ;
	Spatial mode ; 
	
	public TA_Push(Vector3f objectif, Spatial Mode)
	{
		mode = Mode; 
		targetX = objectif.x - mode.getWorldTranslation().x ;
		targetZ = objectif.z - mode.getWorldTranslation().z ;
		
		if(targetX == 0 && targetZ == 0)
		{
			System.out.println("No moving") ; 
		}
		else
		{
			see = Math.abs(targetX) + Math.abs(targetZ) ;
			speed = speed/((float)see) ; 
			timmer = (float)(see)/speed ;
			
			mode.addControl(this);
		}
		
		
	}
	
	@Override
	protected void controlRender(RenderManager arg0, ViewPort arg1) 
	{}

	@Override
	protected void controlUpdate(float fps) 
	{
		i+= see*fps ;
		
		{mode.move(new Vector3f(targetX*fps*speed,0f,targetZ*fps*speed)) ;}
		
		if(i > timmer)
		{
			mode.removeControl(this) ;
		
		//	mode.setTheAnimation(("WAIT"), 0.50f,false);
		}
		if(cutIn)
		{mode.removeControl(this) ;}
	}
}
