package JavaKhan.Map.GE.Light;

import javax.persistence.Embeddable;

import JavaKhan.Map.GE.GE_Model;

@Embeddable
public class GE_Light_Ambient extends GE_Light
{

	public final static String name = "Ambient" ;
	public float strengh ;  
	
	
	public GE_Light_Ambient(float parseFloat) 
	{
		strengh = parseFloat ;
	}



	@Override
	public String getName() 
	{return name;}

}
