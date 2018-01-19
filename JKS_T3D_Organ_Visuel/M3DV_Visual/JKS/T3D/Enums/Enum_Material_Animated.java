package JKS.T3D.Enums;

public enum Enum_Material_Animated implements Material_Path
{

	Crystal_Blue(FVars_MP.AMP_Monster + "@CrystalSpace_Blue.j3m"),
	Lava_Gold(FVars_MP.AMP_Monster + "@Lava_Gold.j3m"),
	
	quadrier1(FVars_MP.AMP_Testing + "ElectRedSelect.j3m"),
	quadrier2(FVars_MP.AMP_Testing + "ElectYellow.j3m"),
	
	blueTiger(FVars_MP.AMP_Testing + "BlueTiger.j3m"),
	whiteTiger(FVars_MP.AMP_Testing + "WhiteTiger.j3m"),
	
	selectBlue(FVars_MP.AMP_Testing + "SelectBlue.j3m"),
	selectYellow(FVars_MP.AMP_Testing + "SelectYellow.j3m"),
	selectRed(FVars_MP.AMP_Testing + "SelectRed.j3m"),
	selectBlack(FVars_MP.AMP_Testing + "SelectBlack.j3m"),
	
	bizzBizz(FVars_MP.AMP_Testing + "BizzBizz.j3m"),
	
	powerBizz(FVars_MP.AMP_Testing + "PowerBizz.j3m"), 
	
	// Holograme
	quadrierVert(FVars_MP.AMP_Genral + "@Quadrier_Green.j3m"),
	quadrierRed(FVars_MP.AMP_Genral + "@Quadrier_Red.j3m"),
	
	//MARK
	INTEROGATION(FVars_MP.AMP_Monster + "@CrystalSpace_Blue_2.j3m"),
	
	// World
	WSPlayer(FVars_MP.AMP_World + "WSPlayer.j3m"), 
	WSMonster(FVars_MP.AMP_World + "WSMonster.j3m"), 
	
	// Combat 
	IsTurn_Ring(FVars_MP.AMP_Combat + "@IsTurn_Ring.j3m") ,
	weapon_NMF(FVars_MP.AMP_Weapon + "@Nightmare_Fuel_Weapon.j3m") ,
	weapon_NMC(FVars_MP.AMP_Weapon + "@Nightmare_Covert_Weapon.j3m") ,

	
	
	space_Glitter(FVars_MP.AMP_Testing + "OPVeryCoolYellow.j3m"),
	//BarrierShield(enumStatic.obstacleMaterialPath + "BarrierShield.j3m"),
	//barrierShield_Ennemy(enumStatic.obstacleMaterialPath + "BarrierShield_Ennemy.j3m"),
	//barrierShield_Ally(enumStatic.obstacleMaterialPath + "BarrierShield_Ally.j3m"),
	//barrierSurrond(enumStatic.obstacleMaterialPath + "BarrierShieldSurrond.j3m"),
	
	;
	
	
	String materialPath ; 
	
	
	Enum_Material_Animated(String path)
	{materialPath = path ;}
	
	@Override
	public String toString()
	{return materialPath ;}
		
	@Override
	public String getPath() 
	{return materialPath ;}
	
	
}


