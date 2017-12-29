package Camera;

import JKS_Head.GVars.GVars_Soul_Model;

public enum Enum_CamType 
{
	FIRST_PERSON("Cam_P1"),
	THIRD_PERSON("Cam_P3"),
	THIRD_PERSON_TOP("Cam_2D_top"),
	THIRD_PERSON_SIDE("Cam_2D_side"),;
	
	String type ; 
	
	Enum_CamType(String Type)
	{
		type = Type ; 
	}
	
	
	public void applyMe(String info)
	{
		GVars_Soul_Model.currentCam = this ; 
		
		try
		{
			switch(this)
			{
				case FIRST_PERSON :
				{Init_Camera.initCameraFirstPerson(); break ;}
				case THIRD_PERSON :
				{Init_Camera.initCameraThirdPerson(); break ;}
				case THIRD_PERSON_TOP :
				{Init_Camera.initCameraThirdPersonFromHigh() ; break ;}
				case  THIRD_PERSON_SIDE:
				{Init_Camera.initCameraThirdPersonFromSide(info) ; break;}
				default :
				{System.out.println("IMPOSSIBLE DE TROUVER CAMERA");}
			}
		}
		catch(Exception e)
		{
			System.out.println("PROBLEM AVEC CAMERA " + this.type + " AND INFO " + info) ;
		}
		
	}
	
	
	public static Enum_CamType getType(String camType)
	{
		for(Enum_CamType t : values())
		{
			if(t.type.equals(camType))
			{return t;}
		}
		
		System.out.println("No camera found " + camType);
		return null ; 
	}
	
	
}
