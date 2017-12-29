package JavaKhan.TgGui.Utils;


import java.util.concurrent.Callable;

import org.lwjgl.input.Mouse;

import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;

import JKS_Head.GVars.GVars_Soul_Model;
import JavaKhan.TgGui.Model.TGuiM_Label_CleanText;
import tonegod.gui.controls.text.Label;
import tonegod.gui.controls.windows.Panel;
import tonegod.gui.core.Element;
import tonegod.gui.core.Screen;
import tonegod.gui.effects.AbstractElementEffect.EffectEvent;


public class Utils_ToneGod 
{

	public static final int textDecalSpace = 3;
	public static final float multSize = 2.0f ;
	
	
	public static void cleanEveryEffect(Element elment)
	{
		elment.removeEffect(EffectEvent.Hover);
		elment.removeEffect(EffectEvent.Press);
		elment.removeEffect(EffectEvent.Release);
		elment.removeEffect(EffectEvent.LoseFocus);
		elment.removeEffect(EffectEvent.Show);
		elment.removeEffect(EffectEvent.TabFocus);
	}
	
	public static void lockIt(Element elment)
	{
		elment.setIsResizable(false);
		elment.setIsEnabled(true);
		elment.setIsMovable(false);
	}
	
	public static void safeAdd(Element tooAdd,Element in)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				in.addChild(tooAdd) ; 
				return null ; 
			}
		});
	}
	
	public static void safeAdd(Element tooAdd,Screen in)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				in.addElement(tooAdd) ; 
				return null ; 
			}
		});
		
	}
	
	public static void safeAdd(Element tooAdd)
	{safeAdd(tooAdd,GVars_Soul_Model.screen) ;}
	
	public static void safeRemove(Element tooRemove,Screen in)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				try
					{in.removeElement(tooRemove) ; }
				catch(Exception e)
					{e.printStackTrace();}
				
				return null ; 
			}
			
		});
	}
	
	
	
	public static void safeRemove(Element tooRemove,Element in)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{
				in.removeChild(tooRemove) ; 
				return null ; 
			}
		});
	}
	
	public static void safeRemove(Element tooRemove)
	{safeRemove(tooRemove,GVars_Soul_Model.screen);}
	
	
	
	public static void addLabelOver_NoChange(Element element, String text, float textSize, boolean isTop)
	{
		Label returning = new Label(element.getScreen(), Vector2f.ZERO) ;
		returning.setHeight(textSize * (1.1f));
		returning.setWidth(element.getWidth());
		returning.setFontSize(textSize);
		returning.setText(text);
		returning.setIgnoreMouse(true);
		
		
		if(isTop)	
			{returning.setPosition(0, - (textSize + textDecalSpace));}
		else
			{returning.setPosition(0, element.getHeight() + textDecalSpace);}
				
		element.addChild(returning) ; 
	}
	
	public static Label addLabelOver(Element element, String text, float textSize, boolean isTop)
	{
		Label returning = new Label(element.getScreen(), element.getPosition(),Vector2f.ZERO) ;
		
		TGuiM_Label_CleanText textLabel = new TGuiM_Label_CleanText(new Vector2f(), textSize, text) ;
		
		if(textLabel.getWidth() > element.getWidth()) 
		{
			returning.setWidth(textLabel.getWidth());
		}
		else
		{
			returning.setWidth(element.getWidth());
		}
		
		returning.setHeight(element.getHeight() + textLabel.getHeight());
		
		if(isTop) 
		{
			element.setY(textLabel.getHeight());
		}
		else 
		{
			element.setY(0);
			textLabel.setY(element.getHeight());
		}
		
		
		returning.addChild(element) ; 
		returning.addChild(textLabel);
	
		return returning ; 
	}
	
	
	public static void addLabelOnTheRight(Element element, String text)
	{
		Label textLabel = new Label(element.getScreen(), Vector2f.ZERO) ;
		textLabel.setText(text);
		textLabel.setIgnoreMouse(true);
		
		setCutSize(textLabel);
		
		textLabel.setPosition(element.getWidth(),element.getHeight()/2 - textLabel.getHeight()/2);
	
		element.attachChild(textLabel) ; 

	}
	
	public static Label addLabelOnTheSide(Element element, String text, float textSize, boolean right)
	{
		Label returning = new Label(element.getScreen(), Vector2f.ZERO) ; 
		returning.setPosition(element.getPosition());
		element.setPosition(0, 0);
		
		TGuiM_Label_CleanText textLabel = new TGuiM_Label_CleanText(Vector2f.ZERO,textSize,text) ;
		
		setNextTo(textLabel,element,right) ;
		
		returning.setWidth(element.getWidth() + textLabel.getWidth());
		
		if(element.getHeight() > textLabel.getHeight())
		{
			returning.setHeight(element.getHeight());
			textLabel.setY(element.getHeight()/2 - textLabel.getHeight()/2);
			System.out.println(element + "Strange");
		}
		else if(element.getHeight() < textLabel.getHeight())
		{
			returning.setHeight(textLabel.getHeight());
			element.setY(textLabel.getHeight()/2 - element.getHeight()/2);
			System.out.println(element + "Fire");
		}
		else 
		{
			returning.setHeight(textLabel.getHeight());
		}
		
		
		returning.addChild(textLabel) ; 
		returning.addChild(element) ;
		
		return returning ; 
	}
	
	public static void setNextTo(Element im, Element toIm, boolean right) 
	{
		
		if(right)	
		{im.setPosition(toIm.getWidth(),im.getY());}
		else
		{
			im.setPosition(0,im.getY());
			toIm.setPosition(im.getWidth(),toIm.getY());
		}
		
		if(im.getHeight() > toIm.getHeight())
		{im.setHeight(toIm.getHeight());}
		
	}

	public static void safeChangeImage(Label etatServer, String isonline)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{etatServer.setColorMap(isonline); return null ; }
		});
	}
	
	public static Vector2f getUnder(Element el,float decalY)
	{return el.getPosition().add(new Vector2f(0, (el.getHeight() + decalY))) ;}
	
	public static Vector2f getNextTo(Element el,float decal)
	{return el.getPosition().add(new Vector2f(el.getWidth() +decal,0)) ;}
	
	
	static Vector3f guiRayOrigin = new Vector3f() ;
	static CollisionResult lastCollision ;
	static CollisionResults results = new CollisionResults() ;
	static Ray elementZOrderRay = new Ray();
	
	public static Element getElementAtMouse(String ... userData) 
	{
		guiRayOrigin.set(Mouse.getX(), Mouse.getY(), 0f);
		
		elementZOrderRay.setOrigin(guiRayOrigin);
		results.clear();
		
		GVars_Soul_Model.screen.getGUINode().collideWith(elementZOrderRay, results);
		Element testEl = null ;
		
		for (CollisionResult result : results) 
		{
			for(String value : userData)
			{
				if (result.getGeometry().getParent().getUserData(value) != null) 
				{
					testEl = ((Element)(result.getGeometry().getParent()));
					return testEl ;
				}
				else
				{}
			}
		}
		
		return null;
	}
	
	public static void safeMove(Element ele, Vector2f here)
	{
		GVars_Soul_Model.app.enqueue(new Callable<Object>()
		{
			public Void call()
			{ele.setPosition(here); return null ;}
		});
	}
	
	public static void setCutSize(Element element)
	{
		element.setHeight(element.getFontSize());
		element.setWidth(element.getHeight()*element.getText().length()/multSize);
	}
	
	public static void setCutSize(Element element, int decalX,int decalY)
	{
		element.setHeight(element.getFontSize() + decalY*2);
		element.setWidth(element.getHeight()*element.getText().length()/multSize + decalX*2);
	}

	public static Vector2f getSizeByEnd(Element element, int decalX, int decalY) 
	{return new Vector2f(element.getX() + element.getWidth() + decalX,element.getY() + element.getHeight() + decalY);}

	public static void setUnder(Panel setIm, Panel underIm)
	{setIm.setPosition(underIm.getPosition().add(new Vector2f(0,underIm.getHeight())));}

	public static void goUpAndDie(Element element, int speed, int time) 
	{
		new goUpAndDie(element,speed,time) ;
		
	}
	
//	public static void getImCenterToIt(Element im, element it)
//	{
//		im.setP
//	}
	
	public static void getImCenterToScreen(Element im,int decalX,int decalY)
	{im.setPosition(GVars_Soul_Model.screen.getWidth()/2 - im.getWidth()/2 + decalX, GVars_Soul_Model.screen.getHeight()/2 - im.getHeight()/2 + decalY);}
	
	public static void setSizeRight(Element element)
	{
		float maxX = 0, maxY =0; 
		Element current ; 
		
		for(Spatial children : element.getChildren())
		{
			try
			{
				current = ((Element)children) ;
				
				if(current.getWidth() + current.getPosition().x > maxX) 
				{maxX = current.getWidth() + current.getPosition().x ;}
				
				if(current.getHeight() + current.getPosition().y > maxY) 
				{maxY = current.getHeight() + current.getPosition().y ;}
			}
			catch(Exception e) 
			{}
		}
		
	}
	
	static class goUpAndDie  extends AbstractControl 
	{
		float total = 0 ; 
		Element message ; 
		int speed ; 
		float time ;
		
		goUpAndDie(Element Message,int Speed, int Time)
		{
			speed = Speed ; 
			time = Time ; 
			message = Message ; 
			message.addControl(this);
		}
		
		@Override
		protected void controlRender(RenderManager arg0, ViewPort arg1) 
		{}

		@Override
		protected void controlUpdate(float fps) 
		{
			if(speed*fps < 1)
			{
				message.move(0, speed*fps, 0) ;
				total += fps/60 ;
			}
			if(total >= time)
			{
				message.removeControl(this) ;
				message.getScreen().removeElement(message) ;
				message = null ;
			}
			
		}
		
	}
}
