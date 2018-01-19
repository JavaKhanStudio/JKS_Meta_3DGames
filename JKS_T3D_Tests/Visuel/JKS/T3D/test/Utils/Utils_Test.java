package JKS.T3D.test.Utils;

import com.jme3.bullet.BulletAppState;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.shadow.DirectionalLightShadowFilter;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.shadow.EdgeFilteringMode;

import JKS.T3D.CollisionEvent.PlayerCharacterControl;
import JKS.T3D.Data.Charac_Main;
import JKS.T3D.Data.MV_Animated_GMOD;
import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Utils.Model3D.Utils_3DObject;

public class Utils_Test 
{
	
	public static final int SHADOWMAP_SIZE = 1024;
	    
    public static DirectionalLightShadowRenderer dlsr;
    public static DirectionalLightShadowFilter dlsf;

	public static BulletAppState initPhysic()
	{
		// activate physics
		BulletAppState bulletAppState = new BulletAppState();
		GVars_Soul_Model.app.getStateManager().attach(bulletAppState);
	    bulletAppState.getPhysicsSpace().setGravity(new Vector3f(0,-30,0));
	    bulletAppState.setSpeed(2);
//	    bulletAppState.setDebugEnabled(true);
	    return bulletAppState ; 
		
	}
	
	public static void buildLights() 
	{
		AmbientLight ambientLight = new AmbientLight();
		ambientLight.setColor(new ColorRGBA(1, 1, 1, 0.5f));
		GVars_Soul_Model.app.getRootNode().addLight(ambientLight);
		
		DirectionalLight sun = new DirectionalLight();
		sun.setColor(new ColorRGBA(1, 1, 1, 0.5f));
		sun.setDirection(new Vector3f(0.5f,1,1));
		
		GVars_Soul_Model.app.getRootNode().addLight(sun);
		
//		makeAShadow(sun) ; 
	}
	
	public static void initCarac(BulletAppState bulletAppState)
	{
		Charac_Main.visualCharacter = new MV_Animated_GMOD(Utils_BuildMarine.buildMarine()) ; 
		Charac_Main.visualCharacter.scale(0.33f) ; 
		
		Charac_Main.physicsCharacter = new PlayerCharacterControl(1.1f, 4.5f,.4f);
		Charac_Main.physicsCharacter.setJumpForce(new Vector3f(.0f,9f,0));
		Charac_Main.physicsCharacter.setPhysicsDamping(1);
		
		Charac_Main.visualCharacter.addControl(Charac_Main.physicsCharacter);
		
		bulletAppState.getPhysicsSpace().add(Charac_Main.physicsCharacter);
	    Utils_3DObject.safeAdd(Charac_Main.visualCharacter);
	}
	
	public static void makeAShadow(DirectionalLight sun)
	{
        dlsr = new DirectionalLightShadowRenderer(GVars_Soul_Model.app.getAssetManager(), SHADOWMAP_SIZE, 3);
        dlsr.setLight(sun);
        dlsr.setLambda(0.55f);
        dlsr.setShadowIntensity(0.8f);
        dlsr.setEdgeFilteringMode(EdgeFilteringMode.PCF8);
        GVars_Soul_Model.app.getViewPort().addProcessor(dlsr);

//        dlsf = new DirectionalLightShadowFilter(GVars_Soul_Model.app.getAssetManager(), SHADOWMAP_SIZE, 3);
//        dlsf.setLight(sun);
//        dlsf.setLambda(0.55f);
//        dlsf.setShadowIntensity(0.8f);
//        dlsf.setEdgeFilteringMode(EdgeFilteringMode.PCFPOISSON);
//        dlsf.setEnabled(true);
//
//        FilterPostProcessor fpp = new FilterPostProcessor(GVars_Soul_Model.app.getAssetManager());
//        fpp.addFilter(dlsf);
//
//        GVars_Soul_Model.app.getViewPort().addProcessor(fpp);
	}
	
	public static Spatial addABox(Vector3f size,Vector3f position, ColorRGBA color)
	{
	    Box b = new Box(size.x,size.y,size.z);
        Geometry geom = new Geometry("Box", b);
        geom.setLocalTranslation(position);
        geom.setShadowMode(ShadowMode.CastAndReceive);
        Material mat = new Material(GVars_Soul_Model.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        Utils_3DObject.safeAdd(geom);
        return geom ;
	}
	
}
