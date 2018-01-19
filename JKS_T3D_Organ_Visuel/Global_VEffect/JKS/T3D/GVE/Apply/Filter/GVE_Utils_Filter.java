package JKS.T3D.GVE.Apply.Filter;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.Filter;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.FogFilter;
import com.jme3.post.filters.TranslucentBucketFilter;
import com.jme3.shadow.DirectionalLightShadowFilter;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.shadow.EdgeFilteringMode;
import com.jme3.water.WaterFilter;

import JKS.T3D.GVE.Apply.Utils_GVE;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Map.GE.Filter.GE_Fog;
import JKS.T3D.Map.GE.Filter.GE_LakeWater;
import JKS.T3D.Map.GE.Filter.GE_Shadow;

public class GVE_Utils_Filter 
{
	
	static final Vector3f lightDir = new Vector3f(-4.9f, -1.3f, 5.9f);
	
	public static Filter makeFog(SimpleApplication app, GE_Fog applyIm)
	{
		FogFilter fog = new FogFilter();
		fog.setName(applyIm.getName()) ;
        fog.setFogColor(new ColorRGBA(0.9f, 0.9f, 0.9f, 1.0f));
        fog.setFogDistance(applyIm.distance);
        fog.setFogDensity(applyIm.density);
       
        Utils_GVE.safe_Volatile_Filter_Add(fog);
        return fog ; 
	}

	

	public static Filter makeWater(SimpleApplication app, GE_LakeWater applyIm)
	{
		WaterFilter water = new WaterFilter(app.getRootNode(), lightDir);
		water.setName(applyIm.getName());
		water.setWaterHeight(applyIm.getHeight()); 
		water.setShoreHardness(10);
		water.setUseRipples(true);
		water.setWaveScale(0.01f);
		water.setSpeed(0.8f);
		
		Utils_GVE.safe_Volatile_Filter_Add(water);
		
		TranslucentBucketFilter  filter = new TranslucentBucketFilter() ;
		
		Utils_GVE.safe_Volatile_Filter_Add(filter);
		
		return water ; 
	}

	public static final int SHADOWMAP_SIZE = 1024;
	
	public static Filter makeShadow(SimpleApplication app, GE_Shadow applyIm) 
	{
//		    DirectionalLightShadowRenderer dlsr = new DirectionalLightShadowRenderer(GVars_Soul_Model.getAssetManager(), applyIm.shadowSize, 3);
//	        dlsr.setLambda(applyIm.lambda);
//	        dlsr.setShadowIntensity(applyIm.shadowIntensity);
//	        dlsr.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
//	        Utils_GVE.safe_Volatile_Filter_Add(dlsr);
//
//	        DirectionalLightShadowFilter dlsf = new DirectionalLightShadowFilter(GVars_Soul_Model.getAssetManager(), applyIm.shadowSize, 3);
//	        dlsf.setLight((DirectionalLight)applyIm.connectLight);
//	        dlsf.setLambda(applyIm.lambda);
//	        dlsf.setShadowIntensity(applyIm.shadowIntensity);
//	        dlsf.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
//	        dlsf.setEnabled(false);
//	        Utils_GVE.safe_Solid_Filter_Add(dlsf);
//	        
//	        return dlsf;
		return null ; 
	}
	
}
