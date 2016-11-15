package JavaKhan.M3DV.ThreadedAction;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

public class TA_Rotation extends AbstractControl 
{
	private float speed ;
	private Spatial model ;
	
	public TA_Rotation(Spatial Model,float Speed)
	{
		this.setSpeed(Speed);
		model = Model ; 
		model.addControl(this);
	}
	
	
	
	@Override
	protected void controlRender(RenderManager arg0, ViewPort arg1) 
	{}

	@Override
	protected void controlUpdate(float im) 
	{model.rotate(0, speed*im, 0) ;}

	public float getSpeed() 
	{return speed;}

	public void setSpeed(float speed) 
	{this.speed = speed;}
	

}
