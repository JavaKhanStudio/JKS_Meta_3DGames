package JavaKhan.Son.Controler;

import JavaKhan.Son.Model.Sounds_Son;

public class Enum_Bruitage
{

	public interface Bruitage_Model
	{
		public default void activate()
		{makeASound(getSon().getPath(),getSon().getIntensity(),getSon().getSpeed()) ;}
		
		public default String getPath()
		{return getSon().getPath();}
		
		public Sounds_Son getSon() ; 
		
	}
	
	
	public enum Enum_Bruitage_Connection implements Bruitage_Model
	{

		  //Objets directement construits
		  ECHEC_CONNECTION(FVars_SoundPath.path_Interface_Connection + "bruitage_interface_de_connexion_echec_de_connexion.wav",1,1),
		  REUSSITE_CONNECTION(FVars_SoundPath.path_Interface_Connection+ "bruitage_interface_de_connexion_reussite_de_connexion.wav",1,1),
		  SURVOL_BOUTTON(FVars_SoundPath.path_Interface_Connection + "bruitage_interface_de_connexion_survol_dun_bouton.wav",1,1) ;
		//Constructeur

		  Sounds_Son son ; 
		 
		  Enum_Bruitage_Connection(String Path,float intensity, float speed)
		  {son = new Sounds_Son(Path,intensity,speed,null) ; }

		
		@Override
		public Sounds_Son getSon() 
		{return son ;}
		  
		 
	}
	
	
	
	public enum Enum_Bruitage_UniterCombat implements Bruitage_Model
	{
		
		//	//	//	//	//	//
		// 	UniterGeneral	//
		//	//	//	//	//	//
		
		SUBIT_DEGAT_LEGER_ARMURE_LEGERE_1(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_leger_1.wav",1,1),
		SUBIT_DEGAT_LEGER_ARMURE_LEGERE_2(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_leger_2.wav",1,1),
		SUBIT_DEGAT_LEGER_ARMURE_LEGERE_3(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_leger_3.wav",1,1),
		
		SUBIT_DEGAT_LOURD_ARMURE_LEGERE_1(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_lourd_3.wav",1,1),
		SUBIT_DEGAT_LOURD_ARMURE_LEGERE_2(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_lourd_3.wav",1,1),
		SUBIT_DEGAT_LOURD_ARMURE_LEGERE_3(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_lourd_3.wav",1,1),
		
		SUBIT_DEGAT_LEGER_VOCAL_1(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_vocal_leger_1.wav",1,1),
		SUBIT_DEGAT_LEGER_VOCAL_2(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_vocal_leger_2.wav",1,1),
		SUBIT_DEGAT_LEGER_VOCAL_3(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_vocal_leger_3.wav",1,1),
		
		SUBIT_DEGAT_LOURD_VOCAL_1(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_vocal_lourd_1.wav",1,1),
		SUBIT_DEGAT_LOURD_VOCAL_2(FVars_SoundPath.pathCombatPersoGeneral + "bruitage_unite_general_combat_subit_vocal_lourd_2.wav",1,1);
		
		Sounds_Son son ; 
		
		Enum_Bruitage_UniterCombat(String Path,float intensity, float speed)
		{son = new Sounds_Son(Path,intensity,speed,null) ; }
		  
		@Override
		public Sounds_Son getSon() 
		{return son ;}
		
	}
	
	
	
	public enum Enum_Bruitage_Combat implements Bruitage_Model
	{
		
		
		// TODO liste bruitage
		
		PROCHAIN_TOUR_ALLIER(FVars_SoundPath.path_Interface_Combat + "Bruitage_interface_prochain_tour_le_sien.wav",1,1) , 
		PROCHAIN_TOUR_ENNEMIE(FVars_SoundPath.path_Interface_Combat + "Bruitage_interface_prochain_tour_aux_autres.wav",1,1),
		ENGAGEMENT(FVars_SoundPath.path_Interface_Combat + "Bruitage_interface_engagement_combat.wav",1,1),
		DEBUT_COMBAT(FVars_SoundPath.path_Interface_Combat + "Stinger_Debut_combat.wav",1,1),
		
		PETITE_VICTOIRE(FVars_SoundPath.path_Interface_Combat + "Stinger_Petite_victoire.wav",1,1),
		DEFAITE(FVars_SoundPath.path_Interface_Combat + "Stinger_Defaite.wav",1,1),
		;
		
		Sounds_Son son ; 
		
		Enum_Bruitage_Combat(String Path,float intensity, float speed)
		{son = new Sounds_Son(Path,intensity,speed,null) ; }
		
		@Override
		public Sounds_Son getSon() 
		{return son ;}
		
	}
	
	
	public static void makeASound(String path,float intensity,float speed)
	{Utils_Sound.makeASound(path,intensity,speed);}
	
}


