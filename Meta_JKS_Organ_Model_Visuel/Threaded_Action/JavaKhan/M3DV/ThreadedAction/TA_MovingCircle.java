package JavaKhan.M3DV.ThreadedAction;

import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

public class TA_MovingCircle extends AbstractControl {

	private float speed ;
	private float rayon ;
	private Spatial model ;
	private float buffer = 0  ; 

	public TA_MovingCircle(float Speed, float rayon, float phase, Spatial Model)
	{
		setSpeed(Speed) ; 
		setRayon(rayon/10) ; 
		model = Model ; 
		model.addControl(this);
		buffer = phase;
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
