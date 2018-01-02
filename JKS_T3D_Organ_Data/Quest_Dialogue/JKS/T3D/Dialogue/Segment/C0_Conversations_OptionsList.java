package JKS.T3D.Dialogue.Segment;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.Entity;


@Entity
public class C0_Conversations_OptionsList
{
	
	private ArrayList<C1_Conversation_Model> possibleConversation ;
	
	public C0_Conversations_OptionsList(C1_Conversation_Model ... p1List )
	{setPossibleConversation((ArrayList<C1_Conversation_Model>) Arrays.asList(p1List)) ;}

	public ArrayList<C1_Conversation_Model> getPossibleConversation() 
	{return possibleConversation;}

	public void setPossibleConversation(ArrayList<C1_Conversation_Model> possibleConversation) 
	{this.possibleConversation = possibleConversation;}
	
	
}
