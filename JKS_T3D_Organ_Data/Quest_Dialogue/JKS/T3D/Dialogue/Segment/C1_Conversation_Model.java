package JKS.T3D.Dialogue.Segment;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class C1_Conversation_Model 
{
	ArrayList<DX_Dialogue_Model> conversationFlow = new ArrayList<DX_Dialogue_Model>();
	
	@Transient int currentConversationLocation = -1;
	HashMap<String,Boolean> optionActivated ;

	public DX_Dialogue_Model nextStep()
	{
		currentConversationLocation ++ ;
		
		if(conversationFlow.size() >= currentConversationLocation)
		{return conversationFlow.get(currentConversationLocation) ;}
		else 
		{
			System.out.println("Liste tester");
			return null ; 
		}
	}
	
	
	public void add(DX_Dialogue_Model dialoguePart) 
	{
		
		conversationFlow.add(dialoguePart) ;
//		if(conversationFlow.conditionList != null)
//		{
//			for(Object condition : conversationFlow.conditionList)
//			{
//				
//			}
//		}
	}


	public DX_Dialogue_Model estimatedNextStep() 
	{
	    if(conversationFlow.size() >= currentConversationLocation + 1)
		{return conversationFlow.get(currentConversationLocation + 1) ;}
	
	    return null ;
	}
	
	
}
