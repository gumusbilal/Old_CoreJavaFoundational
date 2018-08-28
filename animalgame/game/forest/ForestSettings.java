package com.lxisoft.animalgame.game.forest;
import com.lxisoft.animalgame.game.AnimalGame;
import com.lxisoft.animalgame.game.forest.Forest;
import com.lxisoft.animalgame.game.forest.animals.Animals;
import com.lxisoft.animalgame.game.forest.animals.carnivores.lion.Lion;
import com.lxisoft.animalgame.game.forest.animals.carnivores.tiger.Tiger;
import com.lxisoft.animalgame.game.forest.animals.herbivores.elephant.Elephant;
import com.lxisoft.animalgame.game.forest.animals.herbivores.deer.Deer;
import java.util.*;
public class ForestSettings
{
	Scanner scan=new Scanner(System.in);
	Forest forest=new Forest();
	Animals[][] animalList;
	int row,column,i,j;
	int animalId=1;
	int xLoc,yLoc;
	public double[] distance=new double[4];
	String animalName;
	public void setForest()
	{
		System.out.print("Enter the size of the forest: ");
		row=scan.nextInt();
		column=scan.nextInt();
		forest.setForestArea(row,column);
	}

	public void setAnimalLocation(Animals animal)
	{
	
		do
		{
			i=(int)(Math.random()*row)+1;
			j=(int)(Math.random()*column)+1;
	
			animalList=forest.getForestArea();
		}
		while(animalList[i][j]!=null);
			animalList[i][j]=animal;
	}

	
	public void setForestStatus()
	{
		try
		{
			for(int i=1;i<=row;i++)
			{	
				System.out.print("\t\t");
				for (int j=1;j<=column;j++)
			    {
			    	if(animalList[i][j]!=null)
			    	{
			    		if(animalList[i][j] instanceof Lion)
			    		{
			    			System.out.print("\tLion\t");
			    		}

			    		if(animalList[i][j] instanceof Tiger)
			    		{
			    			System.out.print("\tTiger\t");
			    		}

			    		if(animalList[i][j] instanceof Elephant)
			    		{
			    			System.out.print("\tElephant");
			    		}

			    		if(animalList[i][j] instanceof Deer)
			    		{
			    			System.out.print("\tDeer\t");
			    		}
			    	}
					
					else
					{	

						System.out.print("\t*\t");
					}
					
				}

				System.out.println("\n\n\n");

			}
		}

		catch(NullPointerException e)
		{
			System.out.println("0");
		}
		
	}


	public void getHunterAnimalLocation(Animals animal)
	{	String animalName=locateAnimal(animal);
		boolean located=false;
		if(animalList[i][j]!=animal)
		{
			for(i=1;i<=row;i++)
			{  
				for(j=1;j<=column;j++)
				{
					
					if(animalList[i][j]==animal && located==false)
					{
						located=true;
						animalList[i][j]=animal;
						System.out.println( "\nLocation of "+animalName+" : ("+i+","+j+")"); 

					}
					
				}
			}
		}	
	}


	public String locateAnimal(Animals animal)
	{
		
		if(animal instanceof Lion)
		  {
		  	animalName= "Lion";
		  }

		   if(animal instanceof Tiger)
		  {
		  	animalName= "Tiger";
		  }

		    if(animal instanceof Elephant)
		  {
		  	animalName="Elephant";
		  }

		   if(animal instanceof Deer)
		  {
		  	animalName="Deer";
		  }
		  	return animalName;
			
	}


	public void findPreyDistance(int xLoc,int yLoc)
	{	
		for (int i=1;i<=row;i++)
		{
			for (int j=1;j<=column;j++) 
			{
				if(animalList[i][j]!=null) 
				{
					if(i==xLoc && j==yLoc)
					{

					}
					else
					{
						distance[animalId]=Math.sqrt((i-xLoc)*(i-xLoc)+(j-yLoc)*(j-yLoc));
						System.out.println("Distance to Animal"+animalId+" : "+distance[animalId]);
						animalId+=1;
					}
				}
			}
		}

		double[] distanceArray={distance[1],distance[2],distance[3]};
		Arrays.sort(distanceArray);

		for(int i=1;i<=distanceArray.length;i++)
		{

		}

		System.out.println("Nearest Prey for "+animalName+" is: "+distanceArray[1]);
	}
		public double[] getDistance()
		{
			return distance;
		}

		public int getAnimalId()
		{
			return animalId;
		}

}