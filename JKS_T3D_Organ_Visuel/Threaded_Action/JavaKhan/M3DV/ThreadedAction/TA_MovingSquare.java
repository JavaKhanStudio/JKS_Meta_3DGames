package JavaKhan.M3DV.ThreadedAction;

import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

public class TA_MovingSquare extends AbstractControl {

	private float speed ;
	private float xPosition ;
	private float yPosition ;
	private Spatial model ;
	private float buffer = 0  ; 
	private int squareCorner = 0;
	
	public TA_MovingSquare(float Speed, float x, float y, Spatial Model)
	{
		setSpeed(Speed) ; 
		setXPosition(x) ; 
		setYPosition(y) ; 
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
		switch(squareCorner){
		case 0:
			buffer += Math.abs(speed*fps) ;
			model.move(new Vector3f(speed*fps,0,0)) ;
			if(buffer > xPosition)
			{
				speed = -speed ;
				buffer = 0 ; 
				squareCorner=1;
			}
			break;
		case 1:
			buffer += Math.abs(speed*fps) ;
			model.move(new Vector3f(0,speed*fps,0)) ;
			if(buffer > yPosition)
			{
				buffer = 0 ; 
				squareCorner=2;
			}
			break;
		case 2:
			buffer += Math.abs(speed*fps) ;
			model.move(new Vector3f(speed*fps,0,0)) ;
			if(buffer > yPosition)
			{
				speed = -speed ;
				buffer = 0 ; 
				squareCorner=3;
			}
			break;
		case 3:
			buffer += Math.abs(speed*fps) ;
			model.move(new Vector3f(0,speed*fps,0)) ;
			if(buffer > yPosition)
			{
				buffer = 0 ; 
				squareCorner=0;
			}
			break;
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
	
	public float getYPosition() 
	{return yPosition;}

	public void setYPosition(float y) 
	{this.yPosition = y;}
	
}
