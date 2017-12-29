package JavaKhan.Dialogue.Segment;

import javax.persistence.Embeddable;

import JavaKhan.Dialogue.Enum.Enum_Dialogue_Type;

@Embeddable
public class D1_Dialogue_Message extends DX_Dialogue_Model 
{

	String text ; 
	String soundPath ;
	int soundDecal ; 
	
	public D1_Dialogue_Message(String Text, String SoundPath, int SoundDecal)
	{
		text = Text ; 
		soundPath = SoundPath ; 
		soundDecal = SoundDecal ;
	}
	
	@Override
	public Enum_Dialogue_Type getType() 
	{return Enum_Dialogue_Type.DIALOGUE_ANWSER;} 
	
	public String getText() 
	{return text;}

	public void setText(String text) 
	{this.text = text;}

	public String getSoundPath()
	{return soundPath;}

	public void setSoundPath(String soundPath) 
	{this.soundPath = soundPath;}
}
