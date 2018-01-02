package JKS.T3D.SVE.AModel;

import java.util.ArrayList;

import javax.persistence.Embeddable;

import JKS.T3D.Outil.Calcul.Vector3Int;

@Embeddable
public class VEffect_Passive extends AEffect_Model
{

	ArrayList<String> applyPath ; 
	
	public VEffect_Passive(ArrayList<String> ApplyPath, Indexed_Effect Effect, Vector3Int Pos)
	{
		pos = Pos ; 
		applyPath = ApplyPath ; 
		effect = Effect ; 
	}
	
	public ArrayList<String> getApplyPath() 
	{return applyPath;}

	public void setApplyPath(ArrayList<String> applyPath) 
	{this.applyPath = applyPath;}
	
}



