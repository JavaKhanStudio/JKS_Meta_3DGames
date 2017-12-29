package JavaKhan.Indexed;

import javax.jdo.annotations.Index;
import javax.persistence.Entity;

@Entity
public class Indexed 
{

	// Refer as something put in the database as a reference of how that object is suppose to be
	// For exemple how a asset is suppose to look like, the size, the rotation, ect.
	
	@Index(unique="true") public String DBIndexName ;

	public String getDBIndexName()
	{return DBIndexName;}

	public void setDBIndexName(String dBIndexName) 
	{DBIndexName = dBIndexName;} 
	
	
	
	
	
}
