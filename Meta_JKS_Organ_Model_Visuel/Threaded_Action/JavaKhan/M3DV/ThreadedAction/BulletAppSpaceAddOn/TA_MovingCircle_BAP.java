package JavaKhan.M3DV.ThreadedAction.BulletAppSpaceAddOn;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

public class TA_MovingCircle_BAP extends AbstractControl 
{

	private float speed ;
	private float rayon ;
	private Spatial model ;
	private float buffer = 0  ; 
	RigidBodyControl control ; 
	public TA_MovingCircle_BAP(float Speed, float rayon, float phase, Spatial Model, BulletAppState space)
	{
		setSpeed(Speed) ; 
		setRayon(rayon/10) ; 
		model = Model ; 
		model.addControl(this);
		buffer = phase;
		control = new RigidBodyControl(0) ;
		control.setEnabled(true);
		
		Model.addControl(control);
		space.getPhysicsSpace().add(Model);
		control.setKinematic(true);
		
		System.out.println("MOving them circles");
		control = Model.getControl(RigidBodyControl.class) ;
	}
	
	@Override
	protected void controlRender(RenderManager arg0, ViewPort arg1)
	{
	
		
	}

	@Override
	protected void controlUpdate(float fps) 
	{
		buffer += (Math.PI/120); //Math.abs(speed*fps*30) ;
		model.move(new Vector3f(rayon*(float)Math.cos(buffer),rayon*(float)Math.sin(buffer),0)) ;
		//control.setLinearVelocity(new Vector3f(rayon*(float)Math.cos(buffer),rayon*(float)Math.sin(buffer),0)) ;
		//control.setPhysicsLocation(control.getPhysicsLocation().add(new Vector3f(rayon*(float)Math.cos(buffer),rayon*(float)Math.sin(buffer),0)));
		//control.setGravity(new Vector3f(0,40,0)) ;
		//control.activate();
		//System.out.println("buffer :"+buffer+",cos:"+Math.cos(buffer));
		
	}
	
	public float getSpeed() 
	{return speed;}

	public void setSpeed(float speed) 
	{this.speed = speed;}

	public float getRayon() 
	{return rayon;}

	public void setRayon(float rayon) 
	{this.rayon = rayon;}
	
}
