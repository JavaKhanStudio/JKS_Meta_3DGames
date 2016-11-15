package JavaKhan.M3DV.Model;

import java.util.Queue;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.bounding.BoundingVolume;
import com.jme3.collision.Collidable;
import com.jme3.collision.CollisionResults;
import com.jme3.collision.UnsupportedCollisionException;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.SceneGraphVisitor;
import com.jme3.scene.Spatial;
import com.jme3.util.TangentBinormalGenerator;

import JavaKhan.Enums.Enum_Material_Animated;
import JavaKhan.Enums.Enum_Material_Static;
import JavaKhan.PublicName.FVars_GN;
import JavaKhan.Utils.Model3D.Utils_AnimMaterial;

public class Holograme extends Node implements AnimEventListener
{

	public AnimChannel holoChannel;
	protected AnimControl holoControl;
	
	
	public Holograme(Spatial spa)
	{
		Spatial main = spa ; 
		
		spa.setMaterial(Enum_Material_Static.green_glass.getMaterial());
		TangentBinormalGenerator.generate(spa);
		
		main.setUserData(FVars_GN.DT, "Holograme");
		
		holoControl = main.getControl(AnimControl.class);
		
		if(holoControl != null)
		{
			holoControl.addListener(this);
			holoChannel = holoControl.createChannel();
		}
		
		this.attachChild(main) ; 
		Utils_AnimMaterial.applyAnimatedTexture(main,Enum_Material_Animated.quadrierVert.getMaterial(),"MaterielTexture") ; 
	}
	
	public void addInWorld(Vector3f position)
	{
		
	}
	
	@Override
	public void onAnimChange(AnimControl arg0, AnimChannel arg1, String arg2)
	{}

	@Override
	public void onAnimCycleDone(AnimControl arg0, AnimChannel arg1, String arg2)
	{}

	@Override
	public int collideWith(Collidable arg0, CollisionResults arg1)
			throws UnsupportedCollisionException
	{return 0;}

	@Override
	protected void breadthFirstTraversal(SceneGraphVisitor arg0,
			Queue<Spatial> arg1)
	{}

	@Override
	public Spatial deepClone()
	{return null;}

	@Override
	public void depthFirstTraversal(SceneGraphVisitor arg0)
	{}

	@Override
	public int getTriangleCount()
	{return 0;}

	@Override
	public int getVertexCount()
	{return 0;}

	@Override
	public void setModelBound(BoundingVolume arg0)
	{}

	@Override
	public void updateModelBound()
	{}

	
	
}
