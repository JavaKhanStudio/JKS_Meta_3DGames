package JKS.T3D.M3DV.Skin;

import java.util.ArrayList;

import javax.persistence.Entity;

import JKS.T3D.Indexed.Indexed;
import JKS.T3D.SVE.AModel.VEffect_Passive;

@Entity
public class Indexed_Skin extends Indexed //implements Cloneable
{

	
	//ArrayList<String> basicPath ;
	
	ArrayList<Indexed_Texturing> textureList ;
	ArrayList<Indexed_Texturing> coveringTextureList ;
	ArrayList<VEffect_Passive> passiveVEffectList ; 
	
	
	public Indexed_Skin(String Name)
	{
		DBIndexName = Name ; 
		textureList = new ArrayList<Indexed_Texturing>() ; 
		coveringTextureList = new ArrayList<Indexed_Texturing>() ; 
		passiveVEffectList = new ArrayList<VEffect_Passive>() ;
	}
	
	public Indexed_Skin(String Name, ArrayList<Indexed_Texturing> TextureList, ArrayList<Indexed_Texturing> CoveringTexture)
	{
		DBIndexName = Name ; 
		textureList = TextureList ; 
		coveringTextureList = CoveringTexture ;
		passiveVEffectList = new ArrayList<VEffect_Passive>() ;
	}
	
	public String getName()
	{return DBIndexName ;}
	
	public void addTexture(ArrayList<String> path, String textureName)
	{textureList.add(new Indexed_Texturing(path,textureName)) ;}
	
	public ArrayList<Indexed_Texturing> getTextureList()
	{return textureList ;}
	
	public void addCoveringTexture(ArrayList<String> path, String textureName)
	{coveringTextureList.add(new Indexed_Texturing(path,textureName)) ;}
	
	public ArrayList<Indexed_Texturing> getCoveringTextureList()
	{return coveringTextureList ;}
	

	public String getDBIndexName()
	{return DBIndexName;}

	public void setDBIndexName(String dBIndexName) 
	{DBIndexName = dBIndexName;}
	
	public void addPassiveVEffect(VEffect_Passive effect) 
	{passiveVEffectList.add(effect) ; }
	
	public ArrayList<VEffect_Passive> getPassiveVEffectList() 
	{return passiveVEffectList;}

	public void setPassiveVEffectList(ArrayList<VEffect_Passive> passiveEffectList) 
	{this.passiveVEffectList = passiveEffectList;}
	
//	public Indexed_Skin clone() {
//		Indexed_Skin clone = null;
//	    try {
//	    	clone = (Indexed_Skin) super.clone();
//	    } catch(CloneNotSupportedException cnse) {
//	    	cnse.printStackTrace(System.err);
//	    }
//	    return clone;
//	}
}



