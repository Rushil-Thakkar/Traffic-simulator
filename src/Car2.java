import java.awt.Color;
import java.awt.Graphics;


public class Car2 extends Vehicle {
	public Car2(int newx, int newy) 
	{
		// TODO Auto-generated constructor stub
		super(newx,newy);
		width = 60;
		height = 30;
		speed = 10;
	}
	public void paintMe(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		
	}

}
