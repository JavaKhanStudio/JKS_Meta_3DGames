package JKS.T3D.SVE.Light;

import javax.persistence.Embeddable;

import com.jme3.light.SpotLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.LightControl;

import JKS.T3D.Bloc.Bloc_JKSColor;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Outil.Calcul.Vector3Int;
import JKS.T3D.SVE.AModel.Indexed_Effect;

@Embeddable
public class Eff_Light_Spot extends Indexed_Effect
{

	Bloc_JKSColor color ; 
	float radius ; 
	
	public Eff_Light_Spot(Bloc_JKSColor Color, float Radius)
	{
		color = Color ; 
		radius = Radius ; 
	}
	
	public Eff_Light_Spot()
	{
		
		this(Bloc_JKSColor.ORANGE(), 500) ;
	}

	@Override
	public void applyInto(Spatial in, Vector3Int pos) 
	{
//		PointLight lamp_light = new PointLight();
//		lamp_light.setRadius(100);
		System.out.println("Adding a light");
		SpotLight lamp_light = new SpotLight();
		
		lamp_light.setColor(ColorRGBA.White.mult(1.2f));
		lamp_light.setSpotRange(400);
		
		lamp_light.setSpotInnerAngle(0.0f);
		lamp_light.setSpotOuterAngle(1.5f);
		
		lamp_light.setPosition(new Vector3f(in.getWorldTranslation().add(pos.x,500,pos.z)));
		
		lamp_light.setPosition(in.getWorldTranslation());
		LightControl lightControl = new LightControl(lamp_light);
		in.addControl(lightControl) ;

		
		GVars_Soul_Model.getRootNode().addLight(lamp_light);
	}
	
	
	
	
	
}


/*
 * 
		*/
