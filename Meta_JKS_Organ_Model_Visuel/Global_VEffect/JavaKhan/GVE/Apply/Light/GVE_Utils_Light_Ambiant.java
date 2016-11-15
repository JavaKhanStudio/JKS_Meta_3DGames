package JavaKhan.GVE.Apply.Light;

import com.jme3.light.AmbientLight;
import com.jme3.light.Light;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;

import JavaKhan.Map.GE.Light.GE_Light_Ambient;

public class GVE_Utils_Light_Ambiant 
{

	public static Light makeAmbiantLight(Node into, GE_Light_Ambient light)
	{
		AmbientLight al = new AmbientLight();
	    al.setColor(ColorRGBA.White.mult(light.strengh));
	    into.addLight(al);
	    return al ; 
	}
	
	
	
}
