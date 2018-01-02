package JKS.T3D.TgGui.InfoBox;

import org.lwjgl.input.Mouse;

import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.control.AbstractControl;

import JKS.T3D.Head.GVars.GVars_Soul_Model;
import JKS.T3D.Outil.Calcul.Vector2Int;
import JKS.T3D.PublicName.FVars_GN;
import tonegod.gui.controls.windows.Panel;

public abstract class IB_AInfoBox_Model extends Panel 
{
	
	
	// IB = Information box 
	
	//protected int fadingTime ;
	protected float heightValue ;
	protected float widthValue ; 
	protected float decalX ; 
	protected float decalY ; 
	
	protected float followSideX ; 
	protected float followSideY ; 
	
	Vector2Int size ; 
	static protected final String kittyConnerShot = "JavaKhan/Client/Visual2D/Combat/Interface/Image/Empty.png" ; 
	static protected final String type = "DisplayBox"; 
	
	public IB_AInfoBox_Model() 
	{
		super(GVars_Soul_Model.screen);
		setSize() ; 
		
		this.setHeight(getHeighValue());
		this.setWidth(getWidthValue());
		
		setPos() ;
		
		if(getBackground() != null)
			this.setColorMap(getBackground());
		
		this.setUserData(FVars_GN.DT, type);
		this.setIgnoreMouse(true);
		this.setZOrder(0);
	}
	
	
	public void setPos()
	{
		setTopRight() ;
	}
	
	public void setTopRight()
	{
		float posX = getMouse().getX() + followSideX ;
		float posY = getMouse().getY() + followSideY ;
		
		if(posX + this.getWidth() > screen.getWidth())
		{posX = screen.getWidth() - this.getWidth() + followSideX;}
		
		if(posY + this.getHeight() > screen.getHeight())
		{posY = screen.getHeight() - this.getHeight() + followSideY;}
		
		this.setPosition(posX, posY);
	}
	
	public void setDownLeft()
	{
		if(getMouse().x + this.getWidth() > screen.getWidth())
		{this.setPosition(screen.getWidth() - this.getWidth(), screen.getHeight() - getMouse().getY());}
		else
		{this.setPosition(getMouse().x,screen.getHeight() - getMouse().getY());}
	}
	
	
	public Vector2Int getMouse()
	{
		return new Vector2Int(Mouse.getX(),Mouse.getY()) ; 
	}
	
	public float getHeighValue()
	{return heightValue ;}
	
	public float getWidthValue()
	{return widthValue ;}
	
	public void setHeighValue(int value) 
	{heightValue = value ;}
	
	public void setWidthValue(int value)
	{widthValue = value ;}
	
	protected abstract void setSize() ; 
	
	public float decalX()
	{return decalX ;}
	public float decalY()
	{return decalY;}
	
	public abstract String getBackground() ; 
	
	
	public class FollowMe extends AbstractControl  
	{
		public FollowMe()
		{addControl(this);}
		
		public FollowMe(int x,int y)
		{
			followSideX = x ; 
			followSideY = y ; 
			addControl(this);
		}
		
		@Override
		protected void controlRender(RenderManager arg0, ViewPort arg1) 
		{}

		@Override
		protected void controlUpdate(float arg0) 
		{setPos();}
	}
	

}
