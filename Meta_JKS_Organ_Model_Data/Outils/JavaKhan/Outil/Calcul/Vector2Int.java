package JavaKhan.Outil.Calcul;

import javax.persistence.Embeddable;

@Embeddable
public class Vector2Int 
{

	public int x ;
	public int y ;
	
	public Vector2Int()
	{
		x = 0 ;
		y = 0 ;
	}
	
	
	public Vector2Int(int X, int Y) 
	{
		x = X ; 
		y = Y ;
	}
	
	
	public Vector2Int(String code)
	{
		String regex = "," ;
		String[] mass = code.split(regex) ;
		
		x = Integer.parseInt(mass[0]) ;
		y = Integer.parseInt(mass[1]) ;
	}
	
	
	public Vector2Int(String posX, String posY) 
	{
		x = Integer.parseInt(posX) ;
		y = Integer.parseInt(posY) ;
	}


	public int getX()
	{return x ;}
	
	public int getY()
	{return y ;}
	
	public Vector2Int add(Vector2Int in)
	{
		x += in.getX() ;
		y += in.getY() ; 
		return this ; 
	}
	
	public Vector2Int add(int X, int Y)
	{
		x += X ; 
		y += Y ; 
		return this ; 
	}
	
	public Vector2Int substract(int X, int Y)
	{
		x -= X ; 
		y -= Y ; 
		return this ; 
	}
	
	public Vector2Int mul(int mul)
	{
		x = x * mul ;
		y = y * mul ;
		return this ; 
	}
	
	public Vector2Int lookAdd(int X, int Y)
	{
		return new Vector2Int(this.x + X, this.y + Y) ; 
	}
	
	
	public Vector2Int lookMul(int X, int Y)
	{
		return new Vector2Int(this.x * X, this.y * Y) ; 
	}
	
	public void getVector(String code)
	{
		
	}
	
	@Override
	public String toString()
	{return (x + "," + y) ;}
	
	@Override
	public boolean equals(Object object)
	{
		if(
			((Vector2Int)object).x == this.x &&
			((Vector2Int)object).y == this.y
		  )	
			{return true ;}
		else
			{return false ;}
	}
	
}
