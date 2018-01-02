package JKS.T3D.GVE.Filtre;

import java.util.concurrent.Callable;

import com.jme3.math.ColorRGBA;
import com.jme3.post.FilterPostProcessor;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;

import JKS.T3D.GVE.Apply.Utils_GVE;
import JKS.T3D.GVE.Filter.Outline.OutlineFilter;
import JKS.T3D.GVE.Filter.Outline.OutlinePreFilter;
import JKS.T3D.Head.GVars.GVars_Soul_Model;

public class Utils_OutilineFilter
{

	private static OutlinePreFilter outlinePreFilter;
	private static ViewPort outlineViewport ; 
   
	
	
	static public void initFilter()
	{
		FilterPostProcessor outlinefpp = new FilterPostProcessor(GVars_Soul_Model.app.getAssetManager());
		outlineViewport = GVars_Soul_Model.app.getRenderManager().createPreView("outlineViewport", GVars_Soul_Model.getApp().getCamera());
		outlinePreFilter = new OutlinePreFilter();
		outlinefpp.addFilter(outlinePreFilter);
		outlineViewport.addProcessor(outlinefpp);
	}
	
	
	static public void showOutlineEffect(Spatial model, int width, ColorRGBA color) 
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				OutlineFilter outlineFilter = model.getUserData("OutlineFilter");
		
				if (outlineFilter == null) 
				{
					outlineViewport.attachScene(model);
					outlineFilter = new OutlineFilter(outlinePreFilter);
					model.setUserData("OutlineFilter", outlineFilter);
					outlineFilter.setOutlineColor(color);
					outlineFilter.setOutlineWidth(width);
					Utils_GVE.safe_Volatile_Filter_Add(outlineFilter);
				}
				else
				{
					outlineFilter.setEnabled(true);
					outlineFilter.getOutlinePreFilter().setEnabled(true);
				}
				return null ; 
			}
		});
				
	}
	
	static public void removeOutlineEffect(Spatial model)
	{
		
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
					OutlineFilter outlineFilter = model.getUserData("OutlineFilter");
					if(outlineFilter != null) 
					{
						outlineViewport.detachScene(model);
						model.setUserData("OutlineFilter", null);
//						Utils_GVE.safe_Volatile_Filter_Add(outlineFilter);
						outlineFilter = null ; 
					}
					else
					{
						
					}
					return null ; 
			}
		});
		
		
	}	
}
