package JavaKhan.SVE.AModel;

import javax.persistence.Embeddable;

import JavaKhan.Outil.Calcul.Vector3Int;

@Embeddable
public class AEffect_Model 
{
	Vector3Int pos = new Vector3Int(); 
	Vector3Int rotation = new Vector3Int() ; 
	Indexed_Effect effect ;
	
	public Vector3Int getPos() 
	{return pos;}

	public void setPos(Vector3Int pos) 
	{this.pos = pos;}

	public Vector3Int getRotation() 
	{return rotation;}

	public void setRotation(Vector3Int rotation) 
	{this.rotation = rotation;}

	public Indexed_Effect getEffect() 
	{return effect;}

	public void setEffect(Indexed_Effect effect) 
	{this.effect = effect;}

	public String getDBIndexName() 
	{return effect.getDBIndexName() ;}
	
}


