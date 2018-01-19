package JKS.T3D.test.Utils;

import java.util.ArrayList;
import java.util.Hashtable;

import JKS.T3D.Enums.Enum_Animation;
import JKS.T3D.M3DV.Asset.Asset_Avatar;
import JKS.T3D.M3DV.Charact.Anim.Animation_Mapping;
import JKS.T3D.M3DV.Charact.Anim.Animation_Model;
import JKS.T3D.M3DV.Skin.Indexed_Skin;




public class Utils_BuildMarine
{
		
	public static Asset_Avatar buildMarine()
	{
		return new Asset_Avatar(
		"Marine_1",
		"Futuristique_1/Futuristique_1.j3o",
		null,
		buildMarineSkin(),
		getRotationEmpty(),
		1.3f,
		0f,
		"Body/Perso/Armature/soldier_LOD0",
		"Soldier",
		"Body/Perso/Armature/gun_LOD0",
		"gun",
		buildAnimation(),
		new Hashtable<String,ArrayList<String>>()) ;
	}
	
	private static Animation_Mapping buildAnimation()
	{
		Animation_Mapping animationMap = new Animation_Mapping() ;
		   animationMap.put(Enum_Animation.WAIT.animName, new Animation_Model("Idle",1)) ;
		   animationMap.put(Enum_Animation.WALK.animName, new Animation_Model("Walk",1)) ;
		   animationMap.put(Enum_Animation.RUN.animName, new Animation_Model("Run",1.0f)) ;
		   animationMap.put(Enum_Animation.GETHIT.animName, new Animation_Model("Get_Hit",1)) ;
	 	   animationMap.put(Enum_Animation.DIE.animName, new Animation_Model("Die",1)) ;
		   animationMap.put(Enum_Animation.FIRE.animName, new Animation_Model("Shot",1)) ; 
		   animationMap.put(Enum_Animation.FIRE_MULTIPLE.animName, new Animation_Model("Shot_Multiple",1)) ; 
		   animationMap.put(Enum_Animation.ATTACK.animName, new Animation_Model("Melee",1)) ; 
		   animationMap.put(Enum_Animation.JUMPING_STAY.animName, new Animation_Model("Jump_Stay",3)) ; 
		   
	   return animationMap ; 
	}
	
	private static Float[] getRotationEmpty(){
		Float[] rotationEmpty = new Float[3] ;
		rotationEmpty[0] = 0f;
		rotationEmpty[1] = 0f; 
		rotationEmpty[2] = 0f;
		return rotationEmpty ; 
	}
	
	public final static String PersoPath = "JavaKhan/Assets3D/Perso/"; 
	public final static String gruntPath = PersoPath + "Grunt/" ;
	public final static String Marine1 = gruntPath + "Marine/Futuristique_1/" ; 
	public final static String path = "Futuristique_1/" ; 
	
	public static Indexed_Skin buildMarineSkin()
	{
		Indexed_Skin skin = new Indexed_Skin("Futuristique_1") ;
		ArrayList<String> firstPath  = new ArrayList<String>(); 
		ArrayList<String> pathPerso  = new ArrayList<String>(); ;
		ArrayList<String> pathWeapon = new ArrayList<String>(); ;
		
		firstPath.add("Perso") ; firstPath.add("Armature") ;  
		
		pathWeapon.addAll(firstPath) ; pathWeapon.add("gun_LOD0") ; pathWeapon.add("gun") ;
		pathPerso.addAll(firstPath) ; pathPerso.add("soldier_LOD0") ; pathPerso.add("Soldier") ;
		
		skin.addTexture(pathPerso,path + "Soldier.j3m");
		skin.addTexture(pathWeapon,path + "Gun.j3m");
		
		return skin ; 
	}
	
}
