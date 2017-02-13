package JavaKhan.M3DV.Asset;

import java.util.ArrayList;
import java.util.Hashtable;

import JavaKhan.M3DV.Asset.Indexed_Asset_Animated;
import JavaKhan.M3DV.Charact.Anim.Animation_Mapping;
import JavaKhan.M3DV.Skin.Indexed_Skin;

public class Asset_NPC extends Indexed_Asset_Animated
{

	public Asset_NPC(String AssetName, String SpatialPath, Indexed_Skin Indexed_Skin, Float[] Rotation,
			float SizeIndice, float Hauteur, String Logo, String BodyPath, Animation_Mapping ActionPath,
			Hashtable<String, ArrayList<String>> SoundList) 
	{
		super(AssetName, SpatialPath, Indexed_Skin, Rotation, SizeIndice, Hauteur, Logo, BodyPath, ActionPath, SoundList);
		
	}

	
	
	
	
	
}
