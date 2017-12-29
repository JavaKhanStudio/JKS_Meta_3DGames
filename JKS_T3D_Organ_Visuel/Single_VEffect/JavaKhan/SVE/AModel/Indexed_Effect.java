package JavaKhan.SVE.AModel;

import javax.persistence.Embeddable;

import com.jme3.scene.Spatial;

import JavaKhan.Indexed.Indexed;
import JavaKhan.Outil.Calcul.Vector3Int;

@Embeddable
public abstract class Indexed_Effect extends Indexed
{
	

	public abstract void applyInto(Spatial in,Vector3Int pos) ; 
	
	
}
