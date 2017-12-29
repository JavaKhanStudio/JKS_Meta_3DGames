package JavaKhan.Dialogue.Segment;

import java.util.ArrayList;

import javax.persistence.Embeddable;

import JavaKhan.Dialogue.Enum.Enum_Dialogue_Type;

@Embeddable
public class D0_Dialogue_OptionsList extends DX_Dialogue_Model 
{

	public ArrayList<D2_Dialogue_Option> options = new ArrayList<D2_Dialogue_Option>();
	
	public ArrayList<D2_Dialogue_Option> getOptions()
	{
		ArrayList<D2_Dialogue_Option> returning = new ArrayList<D2_Dialogue_Option>() ; 
		
		for(D2_Dialogue_Option option : options)
		{
			if(true) 
			{
				returning.add(option) ;
			}
		}
		
		return returning ; 
	}
	
	@Override
	public Enum_Dialogue_Type getType() 
	{return Enum_Dialogue_Type.DIALOGUE_OPTION_LIST;} 
}
