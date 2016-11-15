package JavaKhan.Utils.Model3D;

import java.util.ArrayList;

import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

public class Utils_Model3DPaths 
{

	public static Spatial getChildrenFromPath(Spatial spa ,final ArrayList<String> path)
	{
		String di = "";  
		Spatial slo = spa ; 
		try
		{
			if(path == null)
			{
				return spa ;
			}
			for(String direction : path)
			{
				di = direction ; 
				spa = ((Node) spa).getChild(direction) ;
				slo = spa ;
			}
			
			return spa ; 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Problem pour " + di + path);
			System.out.println(((Node)slo).getChild(0).getName() + "All the chidlren") ;
		}
		
		return null ;
	}
	
	
}
