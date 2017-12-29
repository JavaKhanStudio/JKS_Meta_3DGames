package JavaKhan.Outil.Calcul;

import javax.persistence.Embeddable;

@Embeddable
public class Vector3Int 
{
	
	public int x ;
	public int y ;
	public int z ; 
	
	public Vector3Int()
	{
		x = 0 ;
		y = 0 ; 
		z = 0 ;
	}
	
	
	public Vector3Int(int X, int Y,int Z) 
	{
		x = X ; 
		y = Y ;
		z = Z ; 
	}
	
	
	public Vector3Int(String code)
	{
		String regex = "," ;
		String[] mass = code.split(regex) ;
		
		x = Integer.parseInt(mass[0]) ;
		y = Integer.parseInt(mass[1]) ;
		z = Integer.parseInt(mass[2]) ;
	}
	
	
	public Vector3Int(String posX, String posY, String posZ) 
	{
		x = Integer.parseInt(posX) ;
		y = Integer.parseInt(posY) ;
		z = Integer.parseInt(posZ) ;
	}

	public int getX()
	{return x ;}
	
	public int getY()
	{return y ;}
	
//	public Vector2Int add(Vector2Int in)
//	{
//		x += in.getX() ;
//		y += in.getY() ; 
//		return this ; 
//	}
//	
//	public Vector2Int add(int X, int Y)
//	{
//		x += X ; 
//		y += Y ; 
//		return this ; 
//	}
//	
//	public Vector2Int substract(int X, int Y)
//	{
//		x -= X ; 
//		y -= Y ; 
//		return this ; 
//	}
//	
//	public Vector2Int mul(int mul)
//	{
//		x = x * mul ;
//		y = y * mul ;
//		return this ; 
//	}
	
//	public Vector2Int lookAdd(int X, int Y)
//	{
//		return new Vector2Int(this.x + X, this.y + Y) ; 
//	}
//	
//	
//	public Vector2Int lookMul(int X, int Y)
//	{
//		return new Vector2Int(this.x * X, this.y * Y) ; 
//	}
//	
//	public void getVector(String code)
//	{
//		
//	}
	
	
	public String getStringCode()
	{return (x + "," + y + "," + z) ;}
	
	
}

