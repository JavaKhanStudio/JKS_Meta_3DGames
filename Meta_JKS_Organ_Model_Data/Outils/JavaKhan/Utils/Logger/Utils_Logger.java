package JavaKhan.Utils.Logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils_Logger 
{
	
	public static final String server = "Server" ;
	public static final String loc_CS = "Combat " + server ;
	public static final String loc_GS = "Game " + server  ;
	public static final String loc_Client = "Client" ;
	public static final String loc_InitServer = "Init " + server ;
	public static final String loc_none = "None" ;

	
	// FINE = PACKET
	
	public static void logInfo(String location, String text)
	{
		Logger.getGlobal().log(Level.INFO, buildLoc(location) + text) ;
	}
	
//	public static void logPacket(String location, Packet packet)
//	{
//		Logger.getGlobal().log(Level.FINE, buildLoc(location), "Packet" + packet.getPacketInformation());
//	}
	
	public static void logError(String locaction, String text, Exception e)
	{
		Logger.getGlobal().log(Level.WARNING,buildLoc(locaction) + text) ;
		Logger.getGlobal().log(Level.SEVERE, locaction, e);
	}
	
	public static void logError(String locaction, String text)
	{
		Logger.getGlobal().log(Level.WARNING,buildLoc(locaction) + text) ;
	}
	
	private static String buildLoc(String location)
	{
		return "[" + location + "] :" ; 
	}
	
}
