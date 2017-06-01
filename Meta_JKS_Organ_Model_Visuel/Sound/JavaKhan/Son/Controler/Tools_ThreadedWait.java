package JavaKhan.Son.Controler;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.jme3.audio.AudioNode;

import JKS_Head.GVars.GVars_Soul_Model;

public class Tools_ThreadedWait extends Thread
{

	AudioNode audio ; 
	int decalRelease ; 
	Callable<Object> toDoNext ;
	
	public Tools_ThreadedWait(AudioNode test, int DecalRelease,Callable<Object> ToDoNext)
	{
		audio = test ;
		decalRelease = DecalRelease ; 
		toDoNext = ToDoNext ;
		this.start();
	}
	
	
	public void run() 
	{
		boolean shouldKeepIn = true; 
		
		while(shouldKeepIn)
		{
			try 
			{Thread.sleep(100);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}
			
			try {
				shouldKeepIn = (boolean) GVars_Soul_Model.app.enqueue(new Callable<Object>()
				{
					public Object call()
					{					
						try
						{
							if(audio.getAudioData().getDuration() - audio.getPlaybackTime() <= decalRelease)
							{
								System.out.println("Ce system a attein le callback") ;
								return false; 
							}
							
							
							System.out.println(audio.getPlaybackTime() + " as playback of");
							System.out.println(audio.getAudioData().getDuration() + " duration");
							System.out.println();
						}
						catch(Exception e)
						{e.printStackTrace();}
						
						return true ; 
					}
					
				}).get();
			} catch (InterruptedException | ExecutionException  e)
			{e.printStackTrace();} 
		}
		
		try 
		{toDoNext.call() ;} 
		catch (Exception e) 
		{e.printStackTrace();} 
    }
	
	
}
