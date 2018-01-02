package JKS.T3D.GVE.Apply.Light;

import com.jme3.light.DirectionalLight;
import com.jme3.light.Light;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;

import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Map.GE.Light.GE_Light_Directional;

public class GVE_Utils_Light_Directional 
{

	public static Light makeDirectionalLight(Node applyInto, GE_Light_Directional applyIm) 
	{
		DirectionalLight dl = new DirectionalLight();
	    dl.setColor(ColorRGBA.White.mult(applyIm.strengh));
	    dl.setDirection(GVars_Soul_Model.app.getCamera().getDirection());
	    applyInto.addLight(dl);
		return dl;
	}
	
	
	
}
