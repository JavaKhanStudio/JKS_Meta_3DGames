package JavaKhan.M3DV.ThreadedAction.BulletAppSpaceAddOn;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

public class TPA_MovingBAF extends AbstractControl 
{

	
	//Vitesse,distance,	X,Z,Y,Commence positif
	
	private float speed ;
	private float distance;
	
	private float speedX ;
	private float speedY ;
	private float speedZ ;
	
	private Spatial model ;
	private float buffer = 0  ; 
	RigidBodyControl control ; 
	
	public TPA_MovingBAF(float Vitesse, float Distance, float vectX, float vectY, float vectZ, boolean startPositif, Spatial Model, BulletAppState space)
	{
		model=Model ;
		control = new RigidBodyControl(0) ;
		Model.addControl(control);
		space.getPhysicsSpace().add(Model);
		Model.getControl(RigidBodyControl.class).getCollisionShape().setScale(Model.getWorldScale());
		control.setKinematic(true);
		
		
		speed = Vitesse ; 
		distance = Distance ; 
		
		speedX = vectX ; 
		speedY = vectY ; 
		speedZ = vectZ ; 
		Model.addControl(this);
	}
	
	@Override
	protected void controlRender(RenderManager arg0, ViewPort arg1)
	{
	
		
	}

	@Override
	protected void controlUpdate(float fps) 
	{
		buffer += fps * Math.abs(speed) ;
		model.move(new Vector3f(speed*speedX*fps,speed*speedY*fps,speed*speedZ*fps)) ;
		
		if(buffer >= distance)
		{
			buffer = 0 ; 
			speed = -speed ; 
		}
	}
	
}