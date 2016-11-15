package JavaKhan.Son.Controler;


	public enum Enum_Musique
	{
		
		CombatMusique1(FVars_SoundPath.path_Musique_Combat + "Musique_combat.wav"),
		MainTheme(FVars_SoundPath.path_Music_Connection + "Main_Menu.wav") ,
		MainThemeOld(FVars_SoundPath.path_Music_Connection + "Main Menu_Old.wav") ,
		//VillageTheme(FVars_SoundPath.path_Musique_World + "musique_world_village.wav") 
		;
		public String path ; 
		Enum_Musique(String Path)
		{
			path = Path ; 
		}
	}
	
	
	
	
	

