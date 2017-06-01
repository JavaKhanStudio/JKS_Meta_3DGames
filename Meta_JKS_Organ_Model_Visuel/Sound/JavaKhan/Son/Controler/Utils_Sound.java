package JavaKhan.Son.Controler;



import java.util.concurrent.Callable;

import com.jme3.audio.AudioNode;

import JKS_Head.GVars.GVars_Soul_Model;


public class Utils_Sound 
{
	
	static AudioNode audio_Musique;
	public static int VOLUME_VALUE = 50 ; 

	Utils_Sound()
	{
		
	}
	
	
	public static void makeAMusique(final Enum_Musique musique)
	{
		if(!GVars_SoundsSettings.allMuted)
		{
			stopAMusique() ;
			
			GVars_Soul_Model.app.enqueue(new Callable<Object>()
			{
				public Void call()
				{
					audio_Musique = new AudioNode(GVars_Soul_Model.app.getAssetManager(), musique.path, true) ; 
					audio_Musique.setName("Musique" + musique.path);
					audio_Musique.setPositional(false);
				    audio_Musique.setLooping(true);
				    audio_Musique.setVolume(1);
				    GVars_Soul_Model.app.getRootNode().attachChild(audio_Musique) ;
				    
					audio_Musique.play();
					return null ; 
				}
			});
		
		}
	}
	
	
	
	
	public static void makeAMusique(final String path)
	{
		if(!GVars_SoundsSettings.allMuted && path != null)
		{
			stopAMusique() ;
			
			GVars_Soul_Model.app.enqueue(new Callable<Object>()
			{
		 
				public Void call()
				{
					System.out.println("[Client] : Playing music : " + path);
					audio_Musique = new AudioNode(GVars_Soul_Model.app.getAssetManager(), path, false) ; 
					audio_Musique.setName("Musique" + path);
					audio_Musique.setPositional(false);
				    audio_Musique.setLooping(true);
				    audio_Musique.setVolume(1.0f);
				    audio_Musique.setPitch(1.0f);
				    GVars_Soul_Model.app.getRootNode().attachChild(audio_Musique) ;
				    
					audio_Musique.play();
				
					return null ; 
				}
			});
		
		}
	}
	
	public static void makeAMusique(final String path,float force)
	{
		if(!GVars_SoundsSettings.allMuted && path != null)
		{
			GVars_Soul_Model.app.enqueue(new Callable<Object>()
			{
				public Void call()
				{
					System.out.println("[Client] : Playing music : " + path);
					AudioNode audio_Musique = new AudioNode(GVars_Soul_Model.app.getAssetManager(), path, false) ; 
					audio_Musique.setName("Musique" + path);
					audio_Musique.setPositional(false);
				    audio_Musique.setLooping(true);
				    audio_Musique.setVolume(force);
				    audio_Musique.setPitch(1.0f);
				    GVars_Soul_Model.app.getRootNode().attachChild(audio_Musique) ;
				    
					audio_Musique.play();
				
					return null ; 
				}
			});
		
		}
	}
	
	
	public static void playMusique(final String path)
	{
		if(!GVars_SoundsSettings.allMuted && path != null)
		{
			stopAMusique() ;
			
			GVars_Soul_Model.app.enqueue(new Callable<Object>()
			{
				public Void call()
				{
					System.out.println("[Client] : Playing music : " + path);
					audio_Musique = new AudioNode(GVars_Soul_Model.app.getAssetManager(), path, false) ; 
					audio_Musique.setName("Musique" + path);
					audio_Musique.setPositional(false);
				    audio_Musique.setLooping(true);
				    audio_Musique.setVolume(0.1f);
				    audio_Musique.setPitch(1.0f);
				    GVars_Soul_Model.app.getRootNode().attachChild(audio_Musique) ;
				    
					audio_Musique.play();
				
					return null ; 
				}
			});
		
		}
	}
	
	
	public static void stopAMusique()
	{
		 
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
	 
			public Void call()
			{
				try
				{
					audio_Musique.stop();
					audio_Musique.pause();
				
					GVars_Soul_Model.app.getRootNode().detachChild(audio_Musique) ;
				}
				catch(Exception e )
				{}
				
				return null ; 
			}
		});
	}
	
	
	public static AudioNode makeASound(final String path)
	{return makeASound(path,10,1) ;}
	
	public static AudioNode makeASound(final String path,final float volume)
	{return makeASound(path,volume,1) ;}
	
	public static AudioNode makeASound(final String path,final float volume,float speed)
	{
		if(!GVars_SoundsSettings.allMuted)
		{
			final AudioNode sound = new AudioNode(GVars_Soul_Model.app.getAssetManager(), path, false) ; 
			GVars_Soul_Model.app.enqueue(new Callable<Object>()
			{
				public Void call()
				{
					sound.setName("Audio Bruitage");
					sound.setPositional(false);
				    sound.setLooping(false);
				    sound.setPitch(speed);
				    sound.setVolume(volume);
				    GVars_Soul_Model.app.getRootNode().attachChild(sound) ;
				    
					sound.play();
		
					return null ; 
				}
			});
			return sound ; 
		}
		
		return null ; 
	    
	}
	
	public static void breakASound(final String path,final float volume,float speed)
	{
		
		
					AudioNode sound ;
					sound = new AudioNode(GVars_Soul_Model.app.getAssetManager(), path, false) ; 
					sound.setName("Audio Bruitage");
					sound.setPositional(false);
				    sound.setLooping(false);
				    sound.setPitch(speed);
				    sound.setVolume(volume);
				    GVars_Soul_Model.app.getRootNode().attachChild(sound) ;
				    
					sound.play();
		
	    
	}
	
	
}
