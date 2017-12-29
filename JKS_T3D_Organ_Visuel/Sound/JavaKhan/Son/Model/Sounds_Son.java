package JavaKhan.Son.Model;

import javax.persistence.Entity;

@Entity
public class Sounds_Son extends Sounds_Model
{

	public Sounds_Son(String Path, float Intensity, float Speed, String index) 
	{super(Path, Intensity, Speed, index);}

}
