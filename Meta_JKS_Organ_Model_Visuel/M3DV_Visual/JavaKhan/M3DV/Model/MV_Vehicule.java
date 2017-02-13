package JavaKhan.M3DV.Model;

import java.util.concurrent.Callable;

import com.jme3.scene.Spatial;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.M3DV.Asset.Indexed_AssetModel;

public class MV_Vehicule extends ModelVisuel
{

	public MV_Vehicule(Indexed_AssetModel asset, String name) {
		super(asset);
		
	}
	
	public void putHologrameHere(final Spatial caseConcept) 
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		 {
			 public Void call()
			 {
				 	solidHolograme.setLocalTranslation(caseConcept.getLocalTranslation());
				 	GVars_Soul_Model.app.getRootNode().attachChild(solidHolograme) ;
					return null ; 
			 }
		 });
	}
	
	
		
		
}
