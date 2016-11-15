package JavaKhan.GVE.Apply.Filter;

import com.jme3.app.SimpleApplication;
import com.jme3.math.Vector3f;
import com.jme3.post.Filter;
import com.jme3.post.filters.TranslucentBucketFilter;
import com.jme3.water.WaterFilter;

import JavaKhan.GVE.Apply.GVE_Utils;
import JavaKhan.Map.GE.Filter.GE_LakeWater;

public class GVE_Utils_Filter_Water 
{

	private static final Vector3f lightDir = new Vector3f(-4.9f, -1.3f, 5.9f); 
	
	public static Filter makeWater(SimpleApplication app, GE_LakeWater applyIm)
	{
		WaterFilter water = new WaterFilter(app.getRootNode(), lightDir);
		water.setName(applyIm.getName());
		water.setWaterHeight(applyIm.getHeight()); 
		water.setShoreHardness(10);
		water.setUseRipples(true);
		water.setWaveScale(0.01f);
		water.setSpeed(0.8f);
		
		GVE_Utils.safe_Volatile_Filter_Add(water);
		
		
		TranslucentBucketFilter  filter = new TranslucentBucketFilter() ;
		
		GVE_Utils.safe_Volatile_Filter_Add(filter);
		
		return water ; 
	}
}


/*
public static void makeWater(SimpleApplication app, Spatial targetedScene, Spatial water)
	{
		SimpleWaterProcessor waterProcessor = new SimpleWaterProcessor(app.getAssetManager());
		waterProcessor.setReflectionScene(targetedScene);
		
		 
		// we set the water plane
		Vector3f waterLocation=new Vector3f(0,0,0);
		waterProcessor.setPlane(new Plane(Vector3f.UNIT_Y, waterLocation.dot(Vector3f.UNIT_Y)));
		app.getViewPort().addProcessor(waterProcessor);
		 
		// we set wave properties
		waterProcessor.setWaterDepth(40);         // transparency of water
		waterProcessor.setDistortionScale(0.05f); // strength of waves
		waterProcessor.setWaveSpeed(0.05f);       // speed of waves
		 
		// we define the wave size by setting the size of the texture coordinates
		Quad quad = new Quad(400,400);
		quad.scaleTextureCoordinates(new Vector2f(6f,6f));
		 
		// we create the water geometry from the quad
		//water.setLocalRotation(new Quaternion().fromAngleAxis(-FastMath.HALF_PI, Vector3f.UNIT_X));
		water.setLocalTranslation(0,0,0);
		water.setShadowMode(ShadowMode.Receive);
		water.setMaterial(waterProcessor.getMaterial());
		water.setCullHint(CullHint.Dynamic);
	}
*/