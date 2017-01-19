package JavaKhan.GVE.Apply;

import java.util.HashMap;
import java.util.concurrent.Callable;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.light.Light;
import com.jme3.math.ColorRGBA;
import com.jme3.post.Filter;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.BloomFilter;
import com.jme3.post.filters.TranslucentBucketFilter;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.shadow.DirectionalLightShadowFilter;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.shadow.EdgeFilteringMode;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.Filter.Outline.OutlineFilter;
import JavaKhan.GVE.Apply.Filter.GVE_Utils_Filter_Fog;
import JavaKhan.GVE.Apply.Filter.GVE_Utils_Filter_Water;
import JavaKhan.GVE.Apply.Light.GVE_Utils_Light_Ambiant;
import JavaKhan.GVE.Apply.Light.GVE_Utils_Light_Directional;
import JavaKhan.Map.GE.GE_Model;
import JavaKhan.Map.GE.Filter.GE_Fog;
import JavaKhan.Map.GE.Filter.GE_LakeWater;
import JavaKhan.Map.GE.Light.GE_Light_Ambient;
import JavaKhan.Map.GE.Light.GE_Light_Directional;

public class GVE_Utils 
{
	
	private static FilterPostProcessor volatileFPP ;
	private static FilterPostProcessor solidFPP ; 
	
	private static HashMap<String,Filter> GE_Filter_list = new HashMap<String,Filter>() ; 
	private static HashMap<String,Light> GE_Light_list = new HashMap<String,Light>() ; 
	
	public static final int SHADOWMAP_SIZE = 1024;
	
	public static void initFilters(SimpleApplication applyInto)
	{
		if(volatileFPP == null)
		{
			volatileFPP = new FilterPostProcessor(applyInto.getAssetManager());
			
			GVars_Soul_Model.app.enqueue(new Callable<Object>()
			{public Void call()
				{applyInto.getViewPort().addProcessor(volatileFPP); return null ; }
			});
			
			resetFilter() ; 
		}
		
	}
	
	public static void ApplyFilter(SimpleApplication applyInto, GE_Model applyIm)
	{
		if(volatileFPP == null)
		{
			volatileFPP = new FilterPostProcessor(applyInto.getAssetManager());
			
			GVars_Soul_Model.app.enqueue(new Callable<Object>()
			{public Void call()
				{applyInto.getViewPort().addProcessor(volatileFPP); return null ; }
			});
			
			resetFilter() ; 
			
		}
		switch(applyIm.getName())
		{
			case GE_LakeWater.name :
				{GE_Filter_list.put(applyIm.getName(),GVE_Utils_Filter_Water.makeWater(applyInto,((GE_LakeWater)applyIm))); break ;}
			case GE_Fog.name :
				{GE_Filter_list.put(applyIm.getName(),GVE_Utils_Filter_Fog.makeFog(applyInto,(GE_Fog)applyIm)); break ; }
			default :
				{System.out.println("GE_UTILS : Impossible de trouver le GE filter : " +  applyIm.getName());}
		}
	}
	
	public static void resetFilter()
	{
	
		
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				volatileFPP.removeAllFilters();
				
				TranslucentBucketFilter  translucent_Filter = new TranslucentBucketFilter() ;
				
				BloomFilter bloom_Filter = new BloomFilter(BloomFilter.GlowMode.Objects);
				bloom_Filter.setDownSamplingFactor(1.0f); 
				bloom_Filter.setBlurScale(0.66f);
				bloom_Filter.setExposurePower(1);
				bloom_Filter.setExposureCutOff(1);
				
				GVE_Utils.safe_Volatile_Filter_Add(translucent_Filter);
				GVE_Utils.safe_Volatile_Filter_Add(bloom_Filter);
				
				return null ; 
			}
		});
	}
	
	public static void safe_Volatile_Filter_Add(Filter fill)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{public Void call()
			{volatileFPP.addFilter(fill); return null;}
		}) ; 
	}
	
	public static void safe_Solid_Filter_Add(Filter fill)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{public Void call()
			{solidFPP.addFilter(fill); return null;}
		}) ; 
	}
	
	
	public static void ApplyLight(Node applyInto, GE_Model applyIm)
	{
		
		System.out.println(applyIm.getName());
		switch(applyIm.getName())
		{
			case GE_Light_Ambient.name : 
				{GE_Light_list.put(applyIm.getName(),GVE_Utils_Light_Ambiant.makeAmbiantLight(applyInto,(GE_Light_Ambient) applyIm)); break ; }
			case GE_Light_Directional.name : 
				{GE_Light_list.put(applyIm.getName(),GVE_Utils_Light_Directional.makeDirectionalLight(applyInto,(GE_Light_Directional) applyIm)); break ; }
			default :
				{System.out.println("GE_UTILS : Impossible de trouver la GE light : " +  applyIm.getName());}
		}
		
	}
	
	public static void removeEffect(Node applyInto, GE_Model applyIm) 
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				volatileFPP.removeFilter(GE_Filter_list.get(applyIm.getName()));
				GE_Filter_list.remove(applyIm.getName()) ;
				return null ; 
			}
		});
		
	}
	
	public static void removeLight(Node applyInto, GE_Model applyIm)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				applyInto.removeLight(GE_Light_list.get(applyIm.getName()));
				GE_Light_list.remove(applyIm.getName()) ;
				return null ; 
			}
		});
	}
	
	
	public static void addShadow(DirectionalLight light)
	{
		DirectionalLightShadowRenderer dlsr = new DirectionalLightShadowRenderer(GVars_Soul_Model.app.getAssetManager(), SHADOWMAP_SIZE, 3);
		dlsr.setLight(light);
		dlsr.setLambda(0.55f);
        dlsr.setShadowIntensity(0.8f);
        dlsr.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
        dlsr.displayDebug();
        GVars_Soul_Model.app.getViewPort().addProcessor(dlsr);

        DirectionalLightShadowFilter dlsf = new DirectionalLightShadowFilter(GVars_Soul_Model.app.getAssetManager(), SHADOWMAP_SIZE, 3);
        dlsr.setLight(light);
        dlsf.setLambda(0.55f);
        dlsf.setShadowIntensity(0.8f);
        dlsf.setEdgeFilteringMode(EdgeFilteringMode.Nearest);
        dlsf.setEnabled(false);

        FilterPostProcessor fpp = new FilterPostProcessor(GVars_Soul_Model.app.getAssetManager());
        fpp.addFilter(dlsf);

        GVars_Soul_Model.app.getViewPort().addProcessor(fpp);
	}
	
	
	
	public static void cleanAll(SimpleApplication app)
	{
		app.getViewPort().clearProcessors(); 
		GE_Filter_list.clear(); 
	}


	public static FilterPostProcessor getVolatileFilter() 
	{return volatileFPP;}
	
	
}
