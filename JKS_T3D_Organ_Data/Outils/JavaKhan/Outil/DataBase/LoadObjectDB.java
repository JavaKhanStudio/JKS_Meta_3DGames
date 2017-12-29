package JavaKhan.Outil.DataBase;

	 public class LoadObjectDB extends Thread
	  {
		 public LoadObjectDB()
		  {this.start();}
		  
		  public void run()
		  {
			  try
			  {
				  String [] server = new String[3] ;
					server[0] = "-conf" ; 
					server[1] = "objectdbEm.conf" ;
					server[2] = "start";
				
					com.objectdb.Server.main
					(server);
			  }
			  catch(Exception e)
			  {e.printStackTrace();  }
		  }
	 }
