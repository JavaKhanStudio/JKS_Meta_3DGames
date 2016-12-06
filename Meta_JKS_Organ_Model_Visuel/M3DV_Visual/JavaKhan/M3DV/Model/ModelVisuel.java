package JavaKhan.M3DV.Model;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import com.jme3.light.PointLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import JKS_Head.GVars.GVars_Soul_Model;
import JKS_Head.GVars.basicImpl;
import JavaKhan.Enums.Enum_Mark;
import JavaKhan.M3DV.Asset.Indexed_AssetModel;
import JavaKhan.M3DV.Skin.Indexed_Skin;
import JavaKhan.M3DV.ThreadedAction.TA_Floting;
import JavaKhan.M3DV.ThreadedAction.TA_Push;
import JavaKhan.M3DV.ThreadedAction.TA_Rotation;
import JavaKhan.Outil.Calcul.Vector2Int;
import JavaKhan.PublicName.FVars_GN;
import JavaKhan.PublicName.FVars_Regex;
import JavaKhan.SVE.AModel.VEffect_Passive;
import JavaKhan.Utils.Logger.Utils_Logger;
import JavaKhan.Utils.Model3D.Utils_3DObject;
import JavaKhan.Utils.Model3D.Utils_AnimMaterial;
import JavaKhan.Utils.Model3D.Utils_Model3DPaths;



public abstract class ModelVisuel extends Node implements basicImpl
{

	PointLight lamp ;
	public ModelVisuel link = this ; 
	public boolean isInWorld = false ; 
	
	public String dataName ; 
	public String publicGroupName ; 
	public String visualName ; 
	protected Indexed_AssetModel asset  ;
	
	public Holograme solidHolograme ; 
	public Spatial main ;  
	public Node targetedSkin ; 
	
	public ArrayList<Spatial> marksList ; 
	
	public Vector2Int modelPos ; 
		
	public ModelVisuel(String path)
	{
		
		main = buildSpatial(asset) ;
		this.attachChild(main) ; 
	}

	public ModelVisuel(Indexed_AssetModel Asset)
	{
		marksList = new ArrayList<Spatial>() ; 
		asset = Asset ;
		
		main = buildSpatial(asset) ;
		this.setUserData("Name", name);
		this.setUserData(FVars_GN.DT, "ModelVisuel");
		
		this.attachChild(main) ; 
	}
	
	
	public Spatial buildSpatial(Indexed_AssetModel asset)
	{
		main = Utils_3DObject.loadDirect(asset.getSpatialPath()) ;
		
		main.scale(asset.getSize()) ; 
		
		if(asset.getTexturePath()!= null && !asset.getTexturePath().isEmpty())
		{main.setMaterial(getMaterial(asset.getTexturePath()));}
		
		if(asset.getSkin() != null)
		{applySkin(main, asset.getSkin());}
		
		try
		{main.rotate(asset.rotation[0],asset.rotation[1] , asset.rotation[2]) ;}
		catch(Exception e)
		{}
		
		main.move(0, asset.hauteur, asset.zDecal) ; 
		
		return main ; 
	}
	
	public ModelVisuel(Spatial spa)
	{this.attachChild(spa) ;}
	
	public void setMain(Spatial spa)
	{this.attachChild(spa) ;}
	
	
	public Spatial getMain()
	{return this.getChild(0) ;}

	
	
	
	
	@SuppressWarnings("unchecked")
	public void addInGame(final Node node)
	{
		getApp().enqueue(new Callable()
		{
			  public Void call()
			  {
				  try
				  {
					  node.attachChild(link) ;
					  isInWorld = true ; 
				  }
				  catch(NullPointerException e)
				  {}
			      return null;
			  }
		});  
	}
	
	public void die(final Node node)
	{
		Utils_3DObject.safeRemove(this, node);
	}

	public void attack() 
	{
		System.out.println("No attack for im") ;
	}
	
	public void setOutOfBattle()
	{
		Utils_Logger.logError("Client", "pas de cleanFromCombat dans cette classe");
	}
	
	
	public void getHit(Vector3f pos)
	{
		System.out.println("Object se fait hit") ; // TODO fait le hit des objets 
	}

	public void combatTeleportTo(Vector3f localTranslation) 
	{
		// TODO A faire teleportation pour object
	}
	
	@SuppressWarnings("unchecked")
	public void addInCombat(Node node,Vector3f localTranslation)
	{
		getApp().enqueue(new Callable()
		{
			  public Void call()
			  {
				  try
				  {
					 link.move(localTranslation) ; 
					 node.attachChild(link) ;
					 isInWorld = true ; 
				  }
				  catch(NullPointerException e)
				  {e.printStackTrace();}
			      return null;
			  }
		});  
	}

	public void push(Vector3f target) 
	{new TA_Push(target,this) ;}
	
	
	
	public void removeIm()
	{
		isInWorld = false ; 
		Utils_3DObject.safeRemove(link);
		Utils_3DObject.safeRemove(lamp);
	}

	
	
	

	public void addLamp(ColorRGBA color, float radium, Vector3f decal) 
	{
		lamp = new PointLight();
		lamp.setColor(color);
		lamp.setRadius(radium);
		lamp.setPosition(new Vector3f(this.getLocalTranslation().add(decal)));

		getApp().getRootNode().addLight(lamp);
	}
	
	public void initHolograme()
	{
		Spatial holo = buildSpatial(asset) ;
		solidHolograme = new Holograme(holo) ; 
	}

	
	public Indexed_AssetModel getAsset()
		{return asset;}

	public void setAsset(Indexed_AssetModel asset)
		{this.asset = asset;}
	
	public Node getTargetedSkin() 
		{return targetedSkin;}
	
	public void setTargetedSkin(Node targetedSkin) 
		{this.targetedSkin = targetedSkin;}
	
	
	
	public void buildTargetedSkin()
		{setTargetedSkin(new Node()) ;}
	
	public void markAsTarget()
		{}
	
	
	
	

	public void applySkin(Spatial spatial,Indexed_Skin skin)
	{

		try
		{
			for(int a = 0; a < skin.getTextureList().size() ; a ++)
			{
				Utils_Model3DPaths.getChildrenFromPath(spatial,skin.getTextureList().get(a).getPath())
								  .setMaterial(getMaterial(skin.getTextureList().get(a).getTexture())) ;
			}
			
			for(int a = 0; a < skin.getCoveringTextureList().size() ; a ++)
			{
				Utils_AnimMaterial.addAnimatedTextureOn(getMaterial(skin.getCoveringTextureList().get(a).getTexture()),
						Utils_Model3DPaths.getChildrenFromPath(spatial,skin.getCoveringTextureList().get(a).getPath())) ; 
			}
			
			for(int a = 0; a < skin.getPassiveVEffectList().size() ; a ++)
			{
				applyPassiveEffect(spatial,skin.getPassiveVEffectList().get(a)) ; 
			}
		}
		catch(Exception e)
		{
			System.out.println("Problem avec skin " + skin.getDBIndexName() + " Sur le spatial " + spatial.getName());
			e.printStackTrace();
		}
	}
	
//	public void applySkin(Indexed_Skin skin)
//	{applySkin(this,skin) ; }
	
	public void addAnimatedTexture(Material mat)
	{Utils_AnimMaterial.applyAnimatedTexture(this.getChild(0),mat,"MaterielTexture") ;}
	
	public void addAnimatedTexture(Material mat,String materialData)
	{Utils_AnimMaterial.applyAnimatedTexture(main,mat,materialData) ;}
	
	
	
	public String getVisualName()
	{return visualName ;}
	
	public void applyPassiveEffect(Spatial spa,VEffect_Passive effect)
	{
		if(spa instanceof Node)
			effect.getEffect().applyInto(getPieceFromPath(spa,effect.getApplyPath()), effect.getPos()) ;
		else 
			effect.getEffect().applyInto(getPieceFromPath(this,effect.getApplyPath()), effect.getPos()) ;
	}
	
	public void purgeAnimatedTexture()
	{
		try
			{Utils_AnimMaterial.removeAnimatedTextureOnIm(this,"Effect") ;}
		catch(Exception e)
			{}
	}
	
	public void removeThatAnimTexture(String textureName) 
	{
		try
		{Utils_AnimMaterial.removeAnimatedTextureOnIm(this,textureName) ;}
		catch(Exception e)
		{}
	}
	

	public Material getMaterial(String path)
	{return getApp().getAssetManager().loadMaterial(path) ;}
	
	public void putHologrameHere(final Spatial caseConcept) 
	{
		getApp().enqueue(new Callable<Object>()
		 {
			 public Void call()
			 {
				 	solidHolograme.setLocalTranslation(caseConcept.getLocalTranslation());
					getApp().getRootNode().attachChild(solidHolograme) ;
					return null ; 
			 }
		 });
	}
	
	public void setPublicGroupName(String PublicGroupName)
	{
		this.publicGroupName = PublicGroupName ;
		this.setUserData("PublicGroupName", PublicGroupName);
		
	}
	
	public Spatial getPieceFromPath(Spatial spa, final ArrayList<String> path)
	{return Utils_Model3DPaths.getChildrenFromPath(spa,path) ;}	

	public String getDataName() 
	{return dataName;}

	public void lookThis_Safe(Vector3f localTranslation) 
	{
		getApp().enqueue(new Callable<Object>()
		{
			public Void call()
			{
				lookAt(localTranslation, Vector3f.ZERO);
				return null ;
			}
		});
	}
	
	public Vector2Int getPos() 
	{return modelPos;}
	
	public void setPos(Vector2Int pos)
	{modelPos = pos ;}
	
	public void addMark(Enum_Mark mark)
	{
		
		float hauteur = asset.getGrandeur() ;
		hauteur += 12.5f ; // remove le plus quand grandeur correctement attribuer  ;
		hauteur += marksList.size() * Enum_Mark.markSize ;
				
		Spatial markSpatial = mark.getMarkSpatial() ; 
		markSpatial.move(0,hauteur,0) ;
		marksList.add(markSpatial) ;
		
		this.attachChild(markSpatial) ; 
		
		new TA_Floting(1,1,markSpatial) ;
		new TA_Rotation(markSpatial, 0.7f) ; 
	}
	
	
	
}




/*
 * public void buildModel(Node targetedNode, Spatial child, Geometry textureModel)
	{
		if(child instanceof Geometry)
		{
			 Geometry solidTexture = textureModel.clone() ;
			 solidTexture.setMesh(((Geometry)child).getMesh());
			 solidTexture.scale(getAsset().size) ;
			 
			 if(getAsset().rotation != null && getAsset().rotation[2] != null) // TODO A RETIRER
			 {solidTexture.rotate(getAsset().rotation[0],getAsset().rotation[1],getAsset().rotation[2]) ; }
			
			 solidTexture.move(0,getAsset().hauteur,getAsset().zDecal) ;
			 targetedNode.attachChild(solidTexture) ;
		 }
		 else if (child instanceof Node)
		 {
			 for(Spatial subChild : ((Node)child).getChildren())
			 {buildModel(targetedNode,subChild,textureModel) ;}
		 }
		 else 
		 {System.out.println("The fuck") ; }
	}
	*/
