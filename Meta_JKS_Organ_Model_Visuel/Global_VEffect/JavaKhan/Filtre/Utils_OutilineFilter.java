package JavaKhan.Filtre;

import java.util.concurrent.Callable;

import com.jme3.math.ColorRGBA;
import com.jme3.post.FilterPostProcessor;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.Filter.Outline.OutlineFilter;
import JavaKhan.Filter.Outline.OutlinePreFilter;

public class Utils_OutilineFilter
{

	private static FilterPostProcessor solidFPP ;
	private static OutlinePreFilter outlinePreFilter;
	private static ViewPort outlineViewport ; 
	
	static public void initFilter()
	{
		solidFPP = new FilterPostProcessor(GVars_Soul_Model.app.getAssetManager()) ; 
		
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{public Void call()
			{GVars_Soul_Model.app.getViewPort().addProcessor(solidFPP); return null ; }
		});
		
		
		outlineViewport = GVars_Soul_Model.app.getRenderManager().createPreView("outlineViewport", GVars_Soul_Model.getApp().getCamera());
		FilterPostProcessor outlinefpp = new FilterPostProcessor(GVars_Soul_Model.app.getAssetManager());
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
					solidFPP.addFilter(outlineFilter);
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
						solidFPP.removeFilter(outlineFilter); 
						outlineFilter = null ; 
					}
					else
					{
						
					}
					return null ; 
			}
		});
		
		
	}
	
	public static FilterPostProcessor getSolidFilter()
	{
		return solidFPP ;
	}

	
}
