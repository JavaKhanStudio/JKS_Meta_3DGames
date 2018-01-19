package JKS.T3D.Map.GE.Filter;

import JKS.T3D.Map.GE.GE_Filter;

public class GE_Shadow  extends GE_Filter
{

	public final static String name = "Shadow" ;
	
	public float lambda ;
	public float shadowIntensity ; 
	public int shadowSize ;
	
	public Object connectLight ; 
	
	public GE_Shadow(Object connectLight)
	{
		lambda = 0.55f ; 
		shadowIntensity = 0.8f ;
		shadowSize = 1024 ; 
		this.connectLight = connectLight ; 
	}
	
	@Override
	public String getName() 
	{return name;}

}
