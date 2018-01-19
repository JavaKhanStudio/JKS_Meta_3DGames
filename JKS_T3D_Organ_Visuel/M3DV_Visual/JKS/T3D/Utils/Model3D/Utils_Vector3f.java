package JKS.T3D.Utils.Model3D;

import com.jme3.math.Vector3f;

public class Utils_Vector3f 
{

	
	public static Vector3f getVectorFromString(String value)
	{
		String[] string = value.split(",") ; 
		return new Vector3f(Float.parseFloat(string[0]),Float.parseFloat(string[1]),Float.parseFloat(string[2])) ;
	}
	
}
