package Main;

public class InitObjectDB 
{
	
	public static void main(String[] arg)
	{
		InitObjectDB() ;
	}
	
	public static void InitObjectDB() 
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
