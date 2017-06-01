package JavaKhan.TgGui.Model;

import java.util.concurrent.Callable;

import com.jme3.math.Vector2f;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.TgGui.Utils.Utils_ToneGod;
import tonegod.gui.controls.text.Label;

public class TGuiM_Label_TextAndValue extends Label 
{

	private Label value ; 
	private Label name ; 
	private static final int decal = 5 ; 
	boolean showTheZero = false ; 
	boolean pureNumbers = false ;
	boolean doRezise = false ;
	
	int currentSize ; 
	int atDiff ; 
	
	public TGuiM_Label_TextAndValue(String valueName, boolean pureNumbers, boolean showTheZero) 
	{
		this(valueName,20, pureNumbers,showTheZero) ;
	}
	
	public TGuiM_Label_TextAndValue(String valueName, int sizeY, boolean pureNumbers, boolean showTheZero) 
	{
		super(GVars_Soul_Model.screen);
		this.setWidth(100);
		pureNumbers = this.pureNumbers ;
		showTheZero = this.showTheZero ;
		name = new TGuiM_Label_CleanText(new Vector2f(), sizeY,valueName) ; 
		value = new Label(GVars_Soul_Model.screen, new Vector2f(name.getWidth(),name.getHeight()), Utils_ToneGod.getNextTo(name,decal)) ; 
		
		this.attachChild(name);
		this.attachChild(value);
	}
	
	
	public void meta_setValue(String modifValue)
	{
		
		if(showTheZero && pureNumbers)
		{}
		else 
		{}
		
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{value.setText(modifValue); return null ;}
		});
		
	}
	
	

}
