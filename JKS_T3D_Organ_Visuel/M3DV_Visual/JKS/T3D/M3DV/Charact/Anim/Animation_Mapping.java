package JKS.T3D.M3DV.Charact.Anim;

import java.util.HashMap;

import javax.persistence.Embeddable;

import JKS.T3D.Enums.Enum_Animation;

@Embeddable
public class Animation_Mapping
{

	private static final long serialVersionUID = 5311541345006822217L;
	HashMap<String,Animation_Model> listHeart  ;
	
	public Animation_Mapping()
	{
		listHeart = new HashMap<String,Animation_Model>() ;
	}
	
	
	public String getPath(Enum_Animation anim)
	{return getAnim(anim.animName) ;}

	public String getAnim(String action) 
	{return this.get(action).getPath() ;}
	
	public Animation_Model get(String key)
	{return listHeart.get(key) ;}
	
	public void put(String key,Animation_Model item)
	{listHeart.put(key, item) ;}
	
}
