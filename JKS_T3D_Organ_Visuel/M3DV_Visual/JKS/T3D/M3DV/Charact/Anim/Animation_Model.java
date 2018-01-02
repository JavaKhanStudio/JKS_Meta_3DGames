package JKS.T3D.M3DV.Charact.Anim;

import javax.persistence.Embeddable;

import JKS.T3D.Indexed.Pathed;

@Embeddable
public class Animation_Model extends Pathed
{

	public Animation_Model(String path, float speed)
	{
		super(path,speed) ;
	}

	public float getSpeed() 
	{return this.getIntensity();}

	public void setSpeed(float speed)
	{this.setSpeed(speed) ;}

	
	
	
}
