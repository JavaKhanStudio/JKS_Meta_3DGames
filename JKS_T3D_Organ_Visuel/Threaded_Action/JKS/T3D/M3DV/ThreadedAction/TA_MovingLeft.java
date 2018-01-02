package JKS.T3D.M3DV.ThreadedAction;

import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

public class TA_MovingLeft extends AbstractControl {

	private float speed ;
	private float xPosition ;
	private Spatial model ;
	private float buffer = 0  ; 
	
	public TA_MovingLeft(float Speed, float x, Spatial Model)
	{
		setSpeed(Speed) ; 
		setXPosition(x) ; 
		model = Model ; 
		model.addControl(this);
	}
	
	@Override
	protected void controlRender(RenderManager arg0, ViewPort arg1)
	{
	
		
	}

	@Override
	protected void controlUpdate(float fps) 
	{
		buffer += Math.abs(speed*fps) ;
		model.move(new Vector3f(speed*fps,0,0)) ;
		if(buffer > xPosition)
		{
			speed = -speed ;
			buffer = 0 ; 
		}
	}
	
	public float getSpeed() 
	{return speed;}

	public void setSpeed(float speed) 
	{this.speed = speed;}

	public float getXPosition() 
	{return xPosition;}

	public void setXPosition(float x) 
	{this.xPosition = x;}
	
}
