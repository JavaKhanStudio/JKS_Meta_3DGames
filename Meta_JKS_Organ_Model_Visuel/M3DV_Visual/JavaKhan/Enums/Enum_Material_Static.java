package JavaKhan.Enums;

public enum Enum_Material_Static implements Material_Path
{

	
	
	green_glass(FVars_MP.SMP_Glass + "Glass_Green.j3m"),
	red_glass(FVars_MP.SMP_Glass + "Glass_Red.j3m"),
	
	// Combat 
	CSAlly(FVars_MP.SMP_Combat + "CSAlly.j3m"), 
	CSEnnemy(FVars_MP.SMP_Combat + "CSEnnemy.j3m"), 
	
	;
	
	
	String materialPath ;
	
	Enum_Material_Static(String path)
	{materialPath = path ;}
	
	@Override
	public String toString()
	{return materialPath ;}
	
//	public Material getMaterial()
//	{return MappingFactory_Material.getAnimatedMaterial(materialPath) ;}
	
	class enumStatic
	{
		
//		private final static String worldMaterialPath = materialPath + "World/"; 
//		private final static String testingMaterialPath = materialPath + "Testing/"; 
//		private final static String obstacleMaterialPath = materialPath + "Anim/Obstacle/"; 
//		private final static String monsterMaterialPath = materialPath + "Monster/"; 
	}

	@Override
	public String getPath() 
	{return materialPath;}
	
}


