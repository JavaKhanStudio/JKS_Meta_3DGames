package JKS.T3D.M3DV.Model;


import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.M3DV.Asset.Indexed_Asset_Animated;


public class Holograme_Individuel extends Holograme
{
	
	Indexed_Asset_Animated asset ; 
	
	private Holograme_Individuel(String path)
	{
		super(GVars_Soul_Model.app.getAssetManager().loadModel(path)) ;
		
	}
	
	public static Holograme_Individuel buildHolograme(Indexed_Asset_Animated ass)
	{
		Holograme_Individuel holo = new Holograme_Individuel(ass.getSpatialPath()) ; 
		holo.setAsset(ass);
		
		return holo ; 
	}
	
	public Indexed_Asset_Animated getAsset() {
		return asset;
	}

	public void setAsset(Indexed_Asset_Animated asset) {
		this.asset = asset;
	}

}


