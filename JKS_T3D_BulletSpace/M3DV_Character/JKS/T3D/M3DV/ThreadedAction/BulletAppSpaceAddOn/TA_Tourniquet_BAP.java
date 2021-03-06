package JKS.T3D.M3DV.ThreadedAction.BulletAppSpaceAddOn;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.shape.Box;

import JKS.T3D.Head.GVars.GVars_Soul_Model;

public class TA_Tourniquet_BAP extends Node {

	private float x=5;
	private float y=0.2f;
	private float z=8;
	private float speed=1;
	
	public TA_Tourniquet_BAP(Spatial ref, float rayon, BulletAppState app)
	{
		
		 Spatial box1 = buildBox(x,y,z); 
		 Spatial box2 = buildBox(x,y,z); 
		 Spatial box3 = buildBox(x,y,z); 
		 Spatial box4 = buildBox(x,y,z); 
		 
		 box1.setLocalTranslation(ref.getWorldTranslation().add(0,-4*rayon,0));
		 box2.setLocalTranslation(ref.getWorldTranslation().add(4*rayon,0,0));
		 box3.setLocalTranslation(ref.getWorldTranslation().add(0,4*rayon,0));
		 box4.setLocalTranslation(ref.getWorldTranslation().add(-4*rayon,0,0));	
		 
		 new TA_MovingCircle_BAP(speed,rayon,0,box1,app) ;
		 new TA_MovingCircle_BAP(speed,rayon,(float)Math.PI/2,box2,app) ;
		 new TA_MovingCircle_BAP(speed,rayon,(float)Math.PI,box3,app) ;
		 new TA_MovingCircle_BAP(speed,rayon,3*(float)Math.PI/2,box4,app) ;
		 
		 this.attachChild(box1) ;
		 this.attachChild(box2) ;
		 this.attachChild(box3) ;
		 this.attachChild(box4) ;
		 
	}
	
	private Spatial buildBox(float x, float y, float z) 
	{
		Box box =new Box(x, y, z); 
		Material material = GVars_Soul_Model.getApp().getAssetManager().loadMaterial("JavaKhan/Texture/Rock/Cubblestone_2/Cubblestone_2.j3m");
		Geometry boxGeometry = new Geometry("Box", box);
        boxGeometry.setMaterial(material);
        return boxGeometry ;
	}
	
}
