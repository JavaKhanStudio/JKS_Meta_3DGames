package JKS.T3D.M3DV.ThreadedAction;

import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

public class TA_Floting extends AbstractControl 
{
	private float speed ;
	private float hauteur ;
	private Spatial model ;
	private float buffer = 0  ; 
	
	
	public TA_Floting(float Speed, float Hauteur, Spatial Model)
	{
		setSpeed(Speed) ; 
		setHauteur(Hauteur) ; 
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
		model.move(new Vector3f(0,speed*fps,0)) ;
		if(buffer > hauteur)
		{
			speed = -speed ;
			buffer = 0 ; 
		}
	}
	
	public float getSpeed() 
	{return speed;}

	public void setSpeed(float speed) 
	{this.speed = speed;}




	public float getHauteur() 
	{return hauteur;}

	public void setHauteur(float hauteur) 
	{this.hauteur = hauteur;}

}
