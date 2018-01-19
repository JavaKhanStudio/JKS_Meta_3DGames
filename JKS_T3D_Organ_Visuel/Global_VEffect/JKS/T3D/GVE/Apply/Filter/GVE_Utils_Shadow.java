package JKS.T3D.GVE.Apply.Filter;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.post.Filter;
import com.jme3.post.FilterPostProcessor;
import com.jme3.shadow.DirectionalLightShadowFilter;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.shadow.EdgeFilteringMode;

import JKS.T3D.GVE.Apply.Utils_GVE;
import JKS.T3D.GVE.Filter.Outline.OutlinePreFilter;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Map.GE.Filter.GE_Shadow;

public class GVE_Utils_Shadow 
{
	public static final int SHADOWMAP_SIZE = 1024;
	DirectionalLightShadowRenderer renderer ; 
	
	public float lambda = 0.55f ;
	public float shadowIntensity = 0.80f ;
	
	public void initFilter()
	{
		renderer = new DirectionalLightShadowRenderer(GVars_Soul_Model.getAssetManager(), SHADOWMAP_SIZE, 3);
		
		renderer.setLambda(lambda);
		renderer.setShadowIntensity(shadowIntensity);
		renderer.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
		GVars_Soul_Model.app.getViewPort().addProcessor(renderer);
	}
	
	
	public static Filter makeShadow(SimpleApplication app, GE_Shadow applyIm) 
	{
		
	        DirectionalLightShadowFilter dlsf = new DirectionalLightShadowFilter(GVars_Soul_Model.getAssetManager(), applyIm.shadowSize, 3);
	        dlsf.setLight((DirectionalLight)applyIm.connectLight);
	        dlsf.setLambda(applyIm.lambda);
	        dlsf.setShadowIntensity(applyIm.shadowIntensity);
	        dlsf.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
	        dlsf.setEnabled(false);
	        Utils_GVE.safe_Solid_Filter_Add(dlsf);
	        
	        return dlsf;
	}
}
