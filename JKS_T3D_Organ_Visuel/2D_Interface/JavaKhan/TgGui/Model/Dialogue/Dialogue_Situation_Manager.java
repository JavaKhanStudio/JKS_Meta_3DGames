package JavaKhan.TgGui.Model.Dialogue;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import com.jme3.audio.AudioNode;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.Dialogue.Segment.C1_Conversation_Model;
import JavaKhan.Dialogue.Segment.D0_Dialogue_OptionsList;
import JavaKhan.Dialogue.Segment.D1_Dialogue_Message;
import JavaKhan.Dialogue.Segment.D2_Dialogue_Option;
import JavaKhan.Dialogue.Segment.DX_Dialogue_Model;
import JavaKhan.Son.Controler.Tools_ThreadedWait;
import JavaKhan.Son.Controler.Utils_Sound;
import tonegod.gui.controls.buttons.Button;
import tonegod.gui.controls.buttons.ButtonAdapter;



public class Dialogue_Situation_Manager 
{

	Dialogue_MainBox diago_Box ; 
	ArrayList<Dialogue_Option> dialogue_options ; 
	C1_Conversation_Model conversation ;
	
	public Dialogue_Situation_Manager(Dialogue_MainBox Diago_Box)
	{
		diago_Box = Diago_Box ;
	}
	
	
	public Object nextStep()
	{nextStep(conversation.nextStep()) ; return null ;}
	
	public void estimatedNextStep()
	{conversation.estimatedNextStep();}
	
	public void nextStep(DX_Dialogue_Model model)
	{
		switch(model.getType())
		{
			case DIALOGUE_ANWSER : useAnwser((D1_Dialogue_Message) model); break ; 
			case DIALOGUE_OPTION : useOption((D2_Dialogue_Option) model); break ; 
			case DIALOGUE_OPTION_LIST : useOptionList((D0_Dialogue_OptionsList) model) ; break ; 
			default : System.out.println("Impossible de trouver ");
		}
	}
	
	public void useAnwser(D1_Dialogue_Message anwser)
	{
		System.out.println("Making a sound");
		
		if(anwser.getSoundPath() != null)
		{
			AudioNode audio = Utils_Sound.makeASound(anwser.getSoundPath());
			new Tools_ThreadedWait(audio,45,new Callable<Object>() 
			{
				public Object call()
				{return nextStep();
				   }
			}) ;
		}
		else 
		{nextStep();}
		
		
		
		
	}
	
	public void useOption(D2_Dialogue_Option option)
	{
		System.out.println("Making a option");
	}
	
	public void useOptionList(D0_Dialogue_OptionsList optionsList)
	{
		System.out.println("Making a dialogueList");
		ArrayList<Button> list = new ArrayList<Button>() ; 
		for(D2_Dialogue_Option options : optionsList.options)
		{
			list.add(buildOptionButton(options)) ; 
		}
		
		diago_Box.addOptionList(list) ; 
	}
	
	private Button buildOptionButton(D2_Dialogue_Option options) 
	{
		Button returning = new ButtonAdapter(GVars_Soul_Model.screen) ; 
		returning.setHeight(100);
		returning.setWidth(100);
		returning.setText(options.getText());
		
		switch(options.getConsequenceType())
		{
			case NOTHING : break ; 
			case SKIP : break ; 
		}
		
		return returning ; 
	}


	public void enterConversation(C1_Conversation_Model Conversation)
	{
		conversation = Conversation ; 
		diago_Box.openConversation() ;
		nextStep(conversation.nextStep());
	}
	
	
	public void quitConversation()
	{
		diago_Box.closeConversation() ;
		conversation = null ; 
	}
	
	
}
