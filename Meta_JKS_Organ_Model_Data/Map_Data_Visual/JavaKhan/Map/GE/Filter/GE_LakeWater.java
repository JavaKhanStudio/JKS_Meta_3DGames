package JavaKhan.Map.GE.Filter;

import javax.persistence.Embeddable;

import JavaKhan.Map.GE.GE_Filter;

@Embeddable
public class GE_LakeWater extends GE_Filter
{
	
	float hauteur ;
	public final static String name = "LakeWater" ;
	
	public GE_LakeWater(float Hauteur)
	{
		hauteur = Hauteur ;
	}
	
	public float getHeight()
	{return hauteur  ;}
	
	@Override
	public String getName() 
	{return name;}

}
