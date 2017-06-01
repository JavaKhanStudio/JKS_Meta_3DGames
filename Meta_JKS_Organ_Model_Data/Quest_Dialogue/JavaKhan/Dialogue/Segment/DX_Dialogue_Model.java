package JavaKhan.Dialogue.Segment;

import java.util.ArrayList;

import javax.persistence.Embeddable;

import JavaKhan.Dialogue.Enum.Enum_Dialogue_Type;

@Embeddable
public abstract class DX_Dialogue_Model 
{
	
	ArrayList conditionList ; 
	
	public abstract Enum_Dialogue_Type getType() ;

}
