package JKS.T3D.Dialogue.Test;

import JKS.T3D.Dialogue.Enum.CC_Nothing;
import JKS.T3D.Dialogue.Enum.Enum_Dialogue_EmotionType;
import JKS.T3D.Dialogue.Segment.C1_Conversation_Model;
import JKS.T3D.Dialogue.Segment.D0_Dialogue_OptionsList;
import JKS.T3D.Dialogue.Segment.D1_Dialogue_Message;
import JKS.T3D.Dialogue.Segment.D2_Dialogue_Option;
import JKS.T3D.Dialogue.Segment.D3_Dialogue_Quit;

public class MOCK_Conversation 
{

	
	private static final String convoPath = "JavaKhan/Dialogue/Data/Quest/Q1_Bridge/" ;
	
	public static C1_Conversation_Model getConvo1()  
	{
		C1_Conversation_Model convo = new C1_Conversation_Model() ; 
		
		
		D1_Dialogue_Message intro  = new D1_Dialogue_Message("Hey, what the hell are you doing here? This zone is under millitary quarantine", null, 0) ; 
		D0_Dialogue_OptionsList rep1 = new D0_Dialogue_OptionsList() ; 
		rep1.options.add(new D2_Dialogue_Option(Enum_Dialogue_EmotionType.Professional, "We got call here, we are the mercenary team")) ; 
		rep1.options.add(new D2_Dialogue_Option(Enum_Dialogue_EmotionType.Douchy, "Oh really? I thought this was the road to the amusement park, my bad.")) ; 
		rep1.options.add(new D2_Dialogue_Option(Enum_Dialogue_EmotionType.BadRef, "Heard somebody called for an exterminator?")) ; 
		
		
		D1_Dialogue_Message anwser_1_1  = new D1_Dialogue_Message("Oh really? Your the one the central send? You don't look that... tought.", convoPath + "Q1_D1_1.wav",0) ; 
		D1_Dialogue_Message anwser_1_2  = new D1_Dialogue_Message("Well, maybie except for that guy, but he could really use some armor, or at lest a shirt.", convoPath + "Q1_D1_2.wav",1000) ; 
		
		D0_Dialogue_OptionsList rep2 = new D0_Dialogue_OptionsList() ; 
		rep2.options.add(new D2_Dialogue_Option(Enum_Dialogue_EmotionType.Professional, "Well were here to help, so what’s the situation?")) ; 
		rep2.options.add(new D2_Dialogue_Option(Enum_Dialogue_EmotionType.Douchy, "Cut the crap what is going on?")) ; 
		
		
		D1_Dialogue_Message anwser_2_1  = new D1_Dialogue_Message("The mine have been overrun by those damn hellspawn! We need someone to get, cut throug and close the portal, Sharp and sweet. No need to clean the whole mess, we can take care of that", convoPath + "Q1_D2_1.wav",0) ; 
		D1_Dialogue_Message anwser_2_2  = new D1_Dialogue_Message("So you get in, hit, run and try not to die in between. Good for you?", convoPath + "Q1_D2_2.wav",0) ; 
		
		D0_Dialogue_OptionsList rep3 = new D0_Dialogue_OptionsList() ; 
		rep3.options.add(new D2_Dialogue_Option(Enum_Dialogue_EmotionType.Professional, "Sound easy enouf. Were on it.")) ; 
		rep3.options.add(new D2_Dialogue_Option(Enum_Dialogue_EmotionType.Douchy, "Good, have my money ready honey, should not take too long.")) ; 
		rep3.options.add(new D2_Dialogue_Option(Enum_Dialogue_EmotionType.None, "Meh, not now, I was actually just looking for the amusement park.")) ; 
		
		D1_Dialogue_Message anwser_3_1  = new D1_Dialogue_Message("Good, here the mine map, its at the end of this bridge. This fog probably keep you from seeing it but there alright", convoPath + "Q1_D3_1.wav",0) ; 
		D1_Dialogue_Message anwser_exit  = new D1_Dialogue_Message("And listen Kido, try not to get killed. I already lost enough good men on this.The last thing I want to add to that death list is a bunch a kids thinking they can be heroes", convoPath + "Q1_DEnd.wav",0) ; 
		
		D3_Dialogue_Quit convo_quit = new D3_Dialogue_Quit() ; 
		
		convo.add(intro);
		convo.add(rep1) ;
		convo.add(anwser_1_1);
		convo.add(anwser_1_2);
		convo.add(rep2);
		convo.add(anwser_2_1);
		convo.add(anwser_2_2);
		convo.add(rep3);
		convo.add(anwser_3_1);
		convo.add(anwser_exit);
		convo.add(convo_quit);
		
		return convo ; 
	}
	
	
	
	
}

