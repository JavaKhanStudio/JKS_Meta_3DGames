package JKS.T3D.M3DV.ThreadedAction.BulletAppSpaceAddOn;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public class TA_Trampoline
{

	RigidBodyControl control ; 
	
	public TA_Trampoline(float force, Spatial Model, BulletAppState space)
	{
		control = new RigidBodyControl(0) ;
		Model.addControl(control);
		space.getPhysicsSpace().add(Model);
		Model.getControl(RigidBodyControl.class).getCollisionShape().setScale(Model.getWorldScale());
		control.setLinearVelocity(new Vector3f(0,force,0)) ;
	}
	
	
	
	
	
}
