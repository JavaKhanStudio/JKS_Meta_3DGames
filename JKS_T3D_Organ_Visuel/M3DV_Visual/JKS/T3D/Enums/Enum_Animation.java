package JKS.T3D.Enums;

import JKS.T3D.M3DV.Asset.Indexed_Asset_Animated;

public enum Enum_Animation 
{

	WALK("WALK"),
	RUN("RUN"),
	GETHIT("GETHIT"),
	DIE("DIE"),
	WAIT("WAIT"),
	STOP("STOP"),
	ATTACK("ATTACK"),
	ATTACK2("ATTACK2"),
	ATTACK3("ATTACK3"),
	FIRE("FIRE"),
	FIRE_MULTIPLE("FIRE_MULTIPLE"),
	FALLING("FALLING"),
	JUMPING("JUMPING"),
	JUMPING_STAY("JUMP_STAY"),
	
	;
	
	public String animName ;
	
	Enum_Animation(String name)
	{
		animName = name ; 
	}
	
	public String getAction(Indexed_Asset_Animated asset)
	{return asset.actionPath.getPath(this) ;}
	
	
	@Override
	public String toString()
	{return animName ; }

	public float getSpeed(Indexed_Asset_Animated asset) 
	{return asset.actionPath.get(animName).getSpeed() ;}
	
	
	
}
