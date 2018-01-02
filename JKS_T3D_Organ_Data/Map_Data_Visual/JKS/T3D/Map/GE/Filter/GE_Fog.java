package JKS.T3D.Map.GE.Filter;

import javax.persistence.Embeddable;

import JKS.T3D.Map.GE.GE_Filter;
import JKS.T3D.Map.GE.GE_Model;

@Embeddable
public class GE_Fog extends GE_Filter
{

	public final static String name = "Fog" ; 
	public float density ; 
	public int distance ;
	
	
	public GE_Fog(float Density,int Distance)
	{
		density = Density ; 
		distance = Distance ;
	}
	
	
	
	
	
	
	
	@Override
	public String getName() 
	{return name ;}

}
