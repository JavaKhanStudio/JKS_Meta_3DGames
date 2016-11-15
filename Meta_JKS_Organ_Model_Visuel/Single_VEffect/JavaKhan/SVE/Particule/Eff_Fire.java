package JavaKhan.SVE.Particule;

import javax.persistence.Embeddable;

import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.Bucket;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.Bloc.Bloc_JKSColor;
import JavaKhan.Outil.Calcul.Vector3Int;
import JavaKhan.SVE.AModel.Indexed_Effect;

@Embeddable
public class Eff_Fire extends Indexed_Effect
{
	
	final static String mat = "Common/MatDefs/Misc/Particle.j3md" ; 
	String texture = "Effects/Explosion/flame.png" ;
	
	Bloc_JKSColor startingColor ;
	Bloc_JKSColor endColor ; 
	
	int wind = 0 ; //0-3
	int strengh = 2 ; // 1-3 
	boolean asSmoke = true  ; 
	
	public Eff_Fire(int Strengh, int Wind,boolean AsSmoke, Bloc_JKSColor Starting, Bloc_JKSColor Ending)
	{
		DBIndexName = "Fire"  ;
		strengh = Strengh ;
		wind = Wind ; 
		asSmoke = AsSmoke ; 
		startingColor = Starting ; 
		endColor = Ending ; 
	}
	
	
	public Eff_Fire()
	{
		this(2,0,true,Bloc_JKSColor.RED(),Bloc_JKSColor.RED().lookAdd(0, 0.5f, 0, -0.5f)) ;
		
	}

	@Override
	public void applyInto(Spatial in, Vector3Int pos) 
	{
			ParticleEmitter fire = 
	            new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 100);
		    Material mat_red = new Material(GVars_Soul_Model.app.getAssetManager(), 
		            "Common/MatDefs/Misc/Particle.j3md");
		    mat_red.setTexture("Texture", GVars_Soul_Model.app.getAssetManager().loadTexture(
		            "Effects/Explosion/flame.png"));
		    
		    fire.setMaterial(mat_red);
		    fire.setImagesX(2); 
		    fire.setImagesY(2); // 2x2 texture animation
		    
		    fire.setEndColor(startingColor.buildRGBAColor());   // red
		    fire.setStartColor(endColor.buildRGBAColor()); // yellow
		   
		    fire.getParticleInfluencer().setInitialVelocity(new Vector3f(wind, strengh, wind));
		    fire.setStartSize(1.0f * strengh);
		    fire.setEndSize(0.6f * strengh);
		    fire.setLowLife(0f * strengh);
		    fire.setHighLife(2f * strengh);
		    fire.getParticleInfluencer().setVelocityVariation(0.4f);
		    fire.move(pos.x,pos.y,pos.z) ;
		    fire.setQueueBucket(Bucket.Translucent);
	 
		    if(asSmoke)
		    {
			    ParticleEmitter smoke = 
			            new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 100);
			    Material mat_Smoke = new Material(GVars_Soul_Model.app.getAssetManager(), 
			            "Common/MatDefs/Misc/Particle.j3md");
			   
			    mat_Smoke.setTexture("Texture", GVars_Soul_Model.app.getAssetManager().loadTexture(
			            "Effects/Smoke/Smoke.png"));
		
			    smoke.setMaterial(mat_Smoke);
			   
			    smoke.setImagesX(15); 
			    smoke.setImagesY(1); // 2x2 texture animation
			    
			    smoke.move((wind/2)* strengh, (strengh)*strengh, (wind/2)*strengh) ; 
			    smoke.move(pos.x,pos.y,pos.z) ;

			    smoke.setNumParticles(1000);
			    smoke.setParticlesPerSec(20 * strengh);
			   
			    smoke.setStartSize(0.1f * strengh);
			    smoke.setEndSize(3 * strengh);
			    
			    smoke.setLowLife(30f * strengh);
			    smoke.setHighLife(3f * strengh);
			   
			    smoke.getParticleInfluencer().setInitialVelocity(new Vector3f(wind*1.5f,(strengh + 1) * strengh,wind*1.5f));
			    smoke.getParticleInfluencer().setVelocityVariation(0.1f);
			   
			   
			    
			    smoke.setQueueBucket(Bucket.Translucent);
			    ((Node) in).attachChild(smoke);
		    }
	    
		    ((Node) in).attachChild(fire);
	}
	
	
	
	
	
	
}
