package JKS.T3D.Indexed;

import javax.persistence.Embeddable;

@Embeddable
public class Pathed extends Indexed implements Cloneable
{

	private String path ; 
	private float intensity ;
	
	public Pathed(String Path, float Intensity)
	{
		path = Path ;
		intensity = Intensity ;
	}
	
	public String getPath() 
	{return path;}
	
	public void setPath(String path)
	{this.path = path;}
	
	public float getIntensity()
	{return intensity;}
	
	public void setIntensity(int intensity) 
	{this.intensity = intensity;} 
	
	
	public Pathed clone() {
		Pathed clone = null;
	    try {
	    	clone = (Pathed) super.clone();
	    } catch(CloneNotSupportedException cnse) {
	    	cnse.printStackTrace(System.err);
	    }
	    return clone;
	}
	
	
}
