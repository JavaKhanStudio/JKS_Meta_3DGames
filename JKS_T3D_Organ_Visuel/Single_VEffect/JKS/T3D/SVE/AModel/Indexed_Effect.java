package JKS.T3D.SVE.AModel;

import javax.persistence.Embeddable;

import com.jme3.scene.Spatial;

import JKS.T3D.Indexed.Indexed;
import JKS.T3D.Outil.Calcul.Vector3Int;

@Embeddable
public abstract class Indexed_Effect extends Indexed
{
	

	public abstract void applyInto(Spatial in,Vector3Int pos) ; 
	
	
}
