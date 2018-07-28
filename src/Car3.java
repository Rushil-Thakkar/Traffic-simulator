import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Car3 extends Vehicle
{
	
	Image myimage;
	public Car3(int newx, int newy) 
	{
		// TODO Auto-generated constructor stub
		super(newx,newy);
		width = 40;
		height =20;
		speed = 15;
		/*try {
			myimage=ImageIO.read(new File("car.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	public void paintMe(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		
	//	g.drawImage(myimage,x,y,null);
	}

}
