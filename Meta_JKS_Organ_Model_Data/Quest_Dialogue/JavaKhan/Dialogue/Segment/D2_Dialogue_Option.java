package JavaKhan.Dialogue.Segment;

import javax.persistence.Embeddable;

import JavaKhan.Dialogue.Enum.CC_Nothing;
import JavaKhan.Dialogue.Enum.ConsequenceCapsule_CC_Model;
import JavaKhan.Dialogue.Enum.Enum_Dialogue_EmotionType;
import JavaKhan.Dialogue.Enum.Enum_Dialogue_Type;
import JavaKhan.Dialogue.Enum.Enum_Option_ConsequenceType;

@Embeddable
public class D2_Dialogue_Option extends DX_Dialogue_Model 
{

	Enum_Dialogue_EmotionType type ; 
	boolean available ; 

	String text ; 
	ConsequenceCapsule_CC_Model consequence ; 
	
	

	public D2_Dialogue_Option(Enum_Dialogue_EmotionType Type, String Text)
	{
		type = Type ; 
		text = Text ; 
		consequence = new CC_Nothing() ; 
	}
	
	
	public D2_Dialogue_Option(Enum_Dialogue_EmotionType Type, String Text, ConsequenceCapsule_CC_Model Consequence)
	{
		type = Type ; 
		text = Text ; 
		consequence = Consequence ; 
	}
	
	public D2_Dialogue_Option(Enum_Dialogue_EmotionType Type, String Text, String require, String giveResult)
	{
		
	}

	@Override
	public Enum_Dialogue_Type getType() 
	{return Enum_Dialogue_Type.DIALOGUE_OPTION;} 
	
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setType(Enum_Dialogue_EmotionType type) {
		this.type = type;
	}
	
	public Enum_Option_ConsequenceType getConsequenceType() {
		return consequence.getType();
	}
}
