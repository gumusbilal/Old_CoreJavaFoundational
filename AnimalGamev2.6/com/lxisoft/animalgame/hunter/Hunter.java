package com.lxisoft.animalgame.hunter;
import com.lxisoft.animalgame.forest.Forest;
import com.lxisoft.animalgame.animals.Animal;
import com.lxisoft.animalgame.animals.Elephant;
import com.lxisoft.animalgame.animalbehaviour.Carnivore;
import com.lxisoft.animalgame.exception.AnimalFarException;
import java.util.Random;
public final class Hunter
	{
		 private boolean alive;
		 private int arrows;
		 private int xLoc;
		 private int yLoc;
		 private boolean hunting;
		 String[] animals= {"Lion" ,"Tiger" , "Deer", "Elephant"};
		 
		 public Hunter()
			{
				 alive=true;
				 Random r= new Random();
				 arrows=(r.nextInt(4)+1);
			}
			
		 public String toString()
			{
				 if(hunting)
					 return "<<HUNTER>>";
				 else
					 return "HUNTER";
			}
			
		 public int getXLoc()
			{
				 return xLoc;
			}
			
	     public void setXLoc(int xLoc)
			{
				 this.xLoc=xLoc;
			}
			
		 public int getYLoc()
			{
				 return yLoc;
			} 
			
		 public void setYLoc(int yLoc)
			{
				 this.yLoc=yLoc;
			}
			
	     public boolean isAlive()
			{
				 return alive;
			}
			
		 public void initHunt() throws InterruptedException
			{
				 hunting=true;
				 Random r= new Random();
				 int choice=(int)(r.nextInt(3));
				 String choose=animals[choice];
				 Animal prey=findNearest(choose);
				 Forest.printGrid(prey,prey);
				 System.out.println("\nHunter looking for a "+choose);
				 Thread.sleep(1500);
				 System.out.println("\nHunter aims "+prey.getID());
				 Thread.sleep(1500);
				 try
					{
						 hunt(prey);
					}
				 catch(AnimalFarException e)
					{
						 System.out.println("\n"+prey.getID()+" is too far away");
					}
				 hunting=false;
			}
			
		 public void hunt(Animal prey) throws AnimalFarException,InterruptedException
			{
				 Random r= new Random();
				 int distance=Math.abs(prey.getXLoc()-getXLoc())+Math.abs(prey.getYLoc()-getYLoc());
				 do
					{
						 if(distance>5)
							{
								 throw new AnimalFarException();
							}
						 System.out.println("\n"+prey.getID()+" is "+distance+" blocks far from hunter.\tHunter has "+arrows+" arrows left, strength of  "+prey.getID()+" is "+prey.getStrength());
						 if(r.nextInt(10)<7) //70% chance for arrow to strike
							{
								 System.out.println("Arrow Hit");
								 Thread.sleep(1000);
								 prey.setStrength(prey.getStrength()-2);
							}
						 else
							{	
								 System.out.println("Arrow Missed");
								 Thread.sleep(1000);
							}
						 arrows--;
						 if(prey instanceof Carnivore || prey instanceof Elephant)
							 distance--;
						 else
							 distance++;
					}while(distance>0 && arrows>0 && prey.getStrength()>0);
					
				 if(prey.getStrength()==0)
					{
						 System.out.println("\nHunter killed "+prey.getID()+"\n\n");
						 prey.dead();
					}
					
				 else if(distance==0 && arrows==0)
					{
						 if(prey instanceof Carnivore || prey instanceof Elephant)
							{
								 System.out.println("\n"+prey.getID()+" killed the Hunter\n\n");
								 alive=false;
							}
						 else
							 System.out.println("\n"+prey.getID()+" escaped from the Hunter\n\n");
					}
					
				 else if(distance>0 && arrows==0)
					{
						 System.out.println("\nNo arrows left, Hunter aborted the plan\n\n");
					}
					
				 else if(distance==0 && arrows>0)
					{
						 System.out.println("\n"+prey.getID()+" got too close, Hunter fled the area\n\n");
					}
			}
			
		 public Animal findNearest(String choose)
			{
				 int smallDistance=99,distance;
				 Animal nearest=null;
				 for(int i=0;i<7;i++)
					{
						 for(int j=0;j<7;j++)
							{
										 Animal animal=Forest.getGridElement(i,j);
										 if(animal!=null && animal.getClass().getSimpleName().equals(choose))
											{
												 distance=Math.abs(animal.getXLoc()-getXLoc())+Math.abs(animal.getYLoc()-getYLoc());
										 
												 if(distance<smallDistance)
													{
														 smallDistance=distance;
														 nearest=animal;
													}
											}
							}
					}
				 return nearest;
			}
	}