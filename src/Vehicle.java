import java.awt.Graphics;


public class Vehicle
{

	int x;
	int y;
	int width =0;
	int height=0;
	int speed=0;
	
	public Vehicle (int newx, int newy)
	{
		x = newx; 
		y= newy; 
	}
	public void paintMe(Graphics g)
	{
		
	}
	public int getX()
	{
		return x;
	}
	public void setX(int newX)
	{
		x= newX;
	}
	public void setY(int newY)
	{
		y= newY;
	}
	public void setspeed(int newY)
	{
		speed= newY;
	}
	public int getSpeed()
	{
		return speed;
	}
	public int getY()
	{
		return y;
	}
	public int getWidth()
	{
		return width;
	}
	
}
