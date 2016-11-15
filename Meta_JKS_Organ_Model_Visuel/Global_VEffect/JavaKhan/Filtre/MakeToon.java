package JavaKhan.Filtre;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.CartoonEdgeFilter;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.texture.Texture;

public class MakeToon
{
	

	static AssetManager assetManager ; 
	static ViewPort viewPort ; 
	
	
	public MakeToon(AssetManager AssetManager, ViewPort ViewPort )
	{
		assetManager = AssetManager ; 
		viewPort = ViewPort ; 
		FilterPostProcessor fpp = new FilterPostProcessor(getAssetManager());
	     getViewPort().addProcessor(fpp);
	
	     CartoonEdgeFilter toon = new CartoonEdgeFilter();
	     toon.setEdgeWidth(0.5f);
	     toon.setDepthThreshold(1);
	     toon.setNormalSensitivity(1);
	     toon.setEdgeColor(ColorRGBA.Black);
	     fpp.addFilter(toon);
	}

	
	public static void makeToonish(Spatial spatial) 
	{
	    if (spatial instanceof Node) 
	    {
	        Node n = (Node) spatial;
	        for (Spatial child : n.getChildren()) 
	        {makeToonish(child);}
	    } 
	    else if (spatial instanceof Geometry) 
	    {
	        Geometry g = (Geometry) spatial;
	        Material m = g.getMaterial();
	        if (m.getMaterialDef().getName().equals("Phong Lighting")) 
	        {
	            Texture t = getAssetManager().loadTexture("Textures/ColorRamp/toon.png");
	            m.setTexture("ColorRamp", t);
	            m.setBoolean("VertexLighting", true);
	            m.setBoolean("UseMaterialColors", true);
	            m.setColor("Specular", ColorRGBA.Black);
	            m.setColor("Diffuse", ColorRGBA.White);
	        }
	    }
	}
	
	private static AssetManager getAssetManager()
	{
		return assetManager ; 
	}

	private static ViewPort getViewPort()
	{
		return viewPort ; 
	}


}