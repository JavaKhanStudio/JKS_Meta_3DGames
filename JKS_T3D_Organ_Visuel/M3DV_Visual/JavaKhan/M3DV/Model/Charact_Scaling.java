package JavaKhan.M3DV.Model;

import javax.persistence.Embeddable;

@Embeddable
public class Charact_Scaling
{

	private boolean isLevelScaling ; 
	
	private int baseLevel ; 
	private float scalingPerLevel ;
	
	public Charact_Scaling()
	{
		isLevelScaling = false ; 
		baseLevel = 0 ;
		scalingPerLevel = 0  ;
	}
	
	public Charact_Scaling(int BaseLevel,float ScalingPerLevel)
	{
		isLevelScaling = true ; 
		baseLevel = BaseLevel ;
		scalingPerLevel = ScalingPerLevel ; 
	}
	
	
	public void lvlScale(int lvl, ModelVisuel model)
	{model.main.scale( 1 + ((lvl - baseLevel) * scalingPerLevel)) ;}
	
	
	public int getBaseLevel() 
	{return baseLevel;}


	public void setBaseLevel(int baseLevel) 
	{this.baseLevel = baseLevel;}


	public float getScalingPerLevel()
	{return scalingPerLevel;}


	public void setScalingPerLevel(float scalingPerLevel) 
	{this.scalingPerLevel = scalingPerLevel;}


	public boolean isLevelScaling() 
	{return isLevelScaling;}


	public void setLevelScaling(boolean isLevelScaling) 
	{this.isLevelScaling = isLevelScaling;}
	
	
	
}
