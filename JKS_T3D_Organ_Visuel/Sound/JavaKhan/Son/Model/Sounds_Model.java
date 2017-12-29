package JavaKhan.Son.Model;

import javax.persistence.Entity;

import JavaKhan.Indexed.Pathed;

@Entity
public class Sounds_Model extends Pathed
{

	private float speed ;
	
	public Sounds_Model(String Path, float Intensity, float Speed, String index) 
	{
		super(Path, Intensity);
		
		setSpeed(Speed) ; 
		setDBIndexName(index);
	}

	public float getSpeed() 
	{return speed;}

	public void setSpeed(float speed) 
	{this.speed = speed;}
	
	
	public Sounds_Model clone() {
		Sounds_Model clone = null;
	    clone = (Sounds_Model) super.clone();
	    return clone;
	}

}
