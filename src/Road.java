import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Road extends JPanel 
{
	final int LANE_HEIGHT=120;
	final int ROAD_WIDTH = 800;
	ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
	
	public Road()
	{
		super();
	}
	public void addCar(Vehicle v)
	{
		cars.add(v);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(Color.WHITE);
		for(int a= LANE_HEIGHT; a < LANE_HEIGHT*4 ; a=a+LANE_HEIGHT)
		{//which lane
			for(int b = 0; b < getWidth(); b =b+35)
			{//which lane
				g.fillRect(b, a, 30, 5);
			}
		}
		//add cars
		for(int a=0; a < cars.size();a++)
		{
			cars.get(a).paintMe(g);
		}
	}
	public void step()
	{
		int flag = 0;
		for(int a=0;a<cars.size();a++)
		{
			Vehicle v = cars.get(a);
			if(collision (v.getX()+v.getSpeed(),v.getY(), v)==false) //no collision
			{
				v.setX(v.getX()+v.getSpeed());
				if(v.getX()>ROAD_WIDTH)
				{
					if(collision (0,v.getY(), v)==false)
					{
						v.setX(0);
					}
				}
				/*for(int b=0;b<cars.size();b++)
				{
					Vehicle u = cars.get(b);
					if(v.getY()== u.getY() && (((u.getX())-(v.getX()))<(v.getX()+v.getSpeed())))//If in the same lane
					{
						if(u.equals(v)==false)// if it is other car than itself
						{
							
							if((v.getY()>40) && (collision (v.getX(),v.getY()-LANE_HEIGHT, v)==false))//slide left if no collision will occur
							{
								v.setY(v.getY()-LANE_HEIGHT);
								if(v instanceof Semi)
								{
									v.setspeed(5);
								}
								else if(v instanceof Car3)
								{
									v.setspeed(15);
								}
								else if(v instanceof Car2)
								{
									v.setspeed(10);
								}

							}
							else if((v.getY()<40+3*LANE_HEIGHT) && (collision (v.getX(),v.getY()+LANE_HEIGHT, v)==false))//slide left if no collision will occur
							{
								v.setY(v.getY()+LANE_HEIGHT);
								if(v instanceof Semi)
								{
									v.setspeed(5);
								}
								else if(v instanceof Car3)
								{
									v.setspeed(15);
								}
								else if(v instanceof Car2)
								{
									v.setspeed(10);
								}
							}
							else
							{
								
											v.setspeed(u.getSpeed());
											//frame.repaint();
								
								
							}
						}
					}
				}*/
			}
			else // car ahead..
			{
				if((v.getY()>40) && (collision (v.getX(),v.getY()-LANE_HEIGHT, v)==false))//slide left if no collision will occur
				{
					v.setY(v.getY()-LANE_HEIGHT);
				}
				else if((v.getY()<40+3*LANE_HEIGHT) && (collision (v.getX(),v.getY()+LANE_HEIGHT, v)==false))//slide left if no collision will occur
				{
					v.setY(v.getY()+LANE_HEIGHT);
				}
				else
				{
					for(int b=0;b< cars.size();b++)
					{
						Vehicle u = cars.get(b);
						if(u.equals(v)==false)
						{
							if(v.getX()<u.getX()+u.getWidth() && //my left side is left of right &&
									v.getX()+v.getWidth()>u.getX()== false)// my right is right of his left
							{
								v.setspeed(u.getSpeed());
								//frame.repaint();
							}
						}
							for(int c=0;c<cars.size();c++)
							{
								Vehicle r = cars.get(c);
								if(v.getY()== r.getY() )//If in the same lane
								{
									if(r.equals(v)==false)// if it is other car than itself
									{
										
										if((v.getY()>40) && (collision (v.getX(),v.getY()-LANE_HEIGHT, v)==false))//slide left if no collision will occur
										{
											v.setY(v.getY()-LANE_HEIGHT);
											if(v instanceof Semi)
											{
												v.setspeed(5);
											}
											else if(v instanceof Car3)
											{
												v.setspeed(15);
											}
											else if(v instanceof Car2)
											{
												v.setspeed(10);
											}

										}
										else if((v.getY()<40+3*LANE_HEIGHT) && (collision (v.getX(),v.getY()+LANE_HEIGHT, v)==false))//slide left if no collision will occur
										{
											v.setY(v.getY()+LANE_HEIGHT);
											if(v instanceof Semi)
											{
												v.setspeed(5);
											}
											else if(v instanceof Car3)
											{
												v.setspeed(15);
											}
											else if(v instanceof Car2)
											{
												v.setspeed(10);
											}
										}
									}
								}
							
						}
					}
				}
			}
		}
	}
	public boolean collision (int x,int y, Vehicle v)
	{
		boolean collide=false;
		for(int a=0;a<cars.size();a++)
		{
			Vehicle u = cars.get(a);
			if(y== u.getY())//If in the same lane
			{
				if(u.equals(v)==false)// if it is other car than itself
				{
					if(x<u.getX()+u.getWidth() && //my left side is left of right &&
							x+v.getWidth()>u.getX())// my right is right of his left
					{
						collide=true;
					}
				}
			}
		}
		return collide;
	}
	

}
