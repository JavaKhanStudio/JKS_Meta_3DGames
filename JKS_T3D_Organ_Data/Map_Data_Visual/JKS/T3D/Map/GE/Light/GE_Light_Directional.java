package JKS.T3D.Map.GE.Light;

import javax.persistence.Embeddable;

import JKS.T3D.Map.GE.GE_Light;
import JKS.T3D.Map.GE.GE_Model;

@Embeddable
public class GE_Light_Directional extends GE_Light
{

	public final static String name = "Directional" ;
	public float strengh ; 
	
	public GE_Light_Directional(float f)
	{
		strengh = f ; 
	}
	
	
	@Override
	public String getName() 
	{return name;}


	

}
