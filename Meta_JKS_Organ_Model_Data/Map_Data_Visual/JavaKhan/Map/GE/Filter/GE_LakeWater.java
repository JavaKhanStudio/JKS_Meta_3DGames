package JavaKhan.Map.GE.Filter;

import javax.persistence.Embeddable;

import JavaKhan.Map.GE.GE_Model;

@Embeddable
public class GE_LakeWater extends GE_Filter
{
	
	int hauteur ;
	public final static String name = "LakeWater" ;
	
	public GE_LakeWater(int Hauteur)
	{
		hauteur = Hauteur ;
	}
	
	public int getHeight()
	{return hauteur  ;}
	
	@Override
	public String getName() 
	{return name;}

}
