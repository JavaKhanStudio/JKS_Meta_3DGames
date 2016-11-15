package JavaKhan.Bloc;

import javax.persistence.Embeddable;

import com.jme3.math.ColorRGBA;

@Embeddable
public class Bloc_JKSColor 
{
	
	public float red ; 
	public float green ; 
	public float blue ; 
	public float force ; 
	
	public Bloc_JKSColor()
	{red = 0 ; green = 0 ; blue = 0 ; force = 0 ;}
	
	public Bloc_JKSColor(float Red, float Green, float Blue, float Force)
	{red = Red ; green = Green ; blue = Blue ; force = Force ;}
	
	public ColorRGBA buildRGBAColor()
	{return new ColorRGBA(red,green,blue,force) ;}

	public Bloc_JKSColor lookAdd(int Red, float Green, int Blue, float Force) 
	{return new Bloc_JKSColor(red+Red,green+Green,blue+Blue,force+Force) ;}
	
	public static Bloc_JKSColor RED()
	{return new Bloc_JKSColor(1,0,0,1) ;}
	
	public static Bloc_JKSColor ORANGE()
	{return new Bloc_JKSColor(1,0.5f,0,1) ;}
	
	public static Bloc_JKSColor WHITE()
	{return new Bloc_JKSColor(1,1,1,1) ;}
	
}
