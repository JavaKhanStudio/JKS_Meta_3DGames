package JavaKhan.Son.Controler;

import java.util.ArrayList;
import java.util.Random;

import com.jme3.audio.AudioNode;
import com.jme3.audio.AudioSource.Status;
import com.jme3.scene.Node;

import JKS_Head.GVars.GVars_Soul_Model;

public class Sounds_Object 
{
	AudioNode currentlyPlaying  ; 
	ArrayList<AudioNode> selection ; 
	public static final Random randomGen = new Random() ;
	
	
	public Sounds_Object(ArrayList<String> selectionList, Node attachOn)
	{
		selection = new ArrayList<AudioNode>() ;
		
		for(String path : selectionList)
		{
			AudioNode node = new AudioNode(GVars_Soul_Model.app.getAssetManager(), path, false) ; 
			node.setVolume(10);
			node.setPitch(1.16f);
			attachOn.attachChild(node) ;
			node.setLooping(false);
			selection.add(node) ;
		}
		
		currentlyPlaying = selection.get(0) ; 
	}
	
	public void tryPush()
	{
		
		if(currentlyPlaying.getStatus().equals(Status.Stopped))
		{
			currentlyPlaying = getNewNode() ;
			
			currentlyPlaying.play();
		}
		
	}
	
	public AudioNode getNewNode()
	{
		return selection.get(randomGen.nextInt(selection.size())) ;
	}
	
	public void stop()
	{
		if(currentlyPlaying != null)
		{currentlyPlaying.stop();}
	}
	
}
