package JavaKhan.GVE.Apply.Filter;

import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;
import com.jme3.post.Filter;
import com.jme3.post.filters.FogFilter;

import JavaKhan.GVE.Apply.Utils_GVE;
import JavaKhan.Map.GE.Filter.GE_Fog;

public class GVE_Utils_Filter_Fog 
{
	
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
	
}
