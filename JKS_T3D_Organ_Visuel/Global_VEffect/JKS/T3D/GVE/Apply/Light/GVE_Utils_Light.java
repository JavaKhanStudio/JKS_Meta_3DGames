package JKS.T3D.GVE.Apply.Light;

import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.light.Light;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;

import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Map.GE.Light.GE_Light_Ambient;
import JKS.T3D.Map.GE.Light.GE_Light_Directional;

public class GVE_Utils_Light 
{

	public static Light makeAmbiantLight(Node into, GE_Light_Ambient light)
	{
		AmbientLight al = new AmbientLight();
	    al.setColor(ColorRGBA.White.mult(light.strengh));
	    into.addLight(al);
	    return al ; 
	}

	public static Light makeDirectionalLight(Node applyInto, GE_Light_Directional applyIm) 
	{
		DirectionalLight dl = new DirectionalLight();
	    dl.setColor(ColorRGBA.White.mult(applyIm.strengh));
	    dl.setDirection(GVars_Soul_Model.app.getCamera().getDirection());
	    applyInto.addLight(dl);
		return dl;
	}

}
