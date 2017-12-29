package Main;


public class Utils_Threaded_DataBase extends Thread
{
	  public Utils_Threaded_DataBase()
	  {
		  this.start(); 
		  
		  try
		  {Thread.sleep(1000);}
		  catch (Exception e)
		  {}
	  }
	  
	  public void run()
	  {
		  	  
		  try
		  {
			  String [] server = new String[3] ;
				server[0] = "-conf" ; 
				server[1] = "objectdbEm.conf" ; 
				server[2] = "start";
				System.out.println("Launch Database") ;
				com.objectdb.Server.main
				(server);
				
		  }
		  catch(Exception e)
		  {e.printStackTrace();}
	  }
	  
}