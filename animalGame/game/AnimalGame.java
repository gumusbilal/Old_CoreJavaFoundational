package com.lxisoft.animalGame.game;
import java.util.*;
import com.lxisoft.animalGame.game.animal.Animal;
import com.lxisoft.animalGame.game.forest.ForestControl;
import com.lxisoft.animalGame.game.animal.carnivorous.Lion;
import com.lxisoft.animalGame.game.animal.carnivorous.Tiger;
import  com.lxisoft.animalGame.game.animal.carnivorous.Athulya;
import com.lxisoft.animalGame.game.animal.herbivorous.Rabbit;
import com.lxisoft.animalGame.game.animal.herbivorous.Deer;
import com.lxisoft.animalGame.game.animal.herbivorous.Elephant;
public class AnimalGame

{  
	
	int animalCount,raw,column,fighterlife;
	double[] distance;
	Animal animal,animalObject1,animalObject2,animalOne,animalTwo;
	String space,animalName;
	String[] name;
	double smallestDistance;
	Lion lion=new Lion();
	public ArrayList<Lion> lions=new ArrayList<Lion>();
	Tiger tiger=new Tiger();
	Rabbit rabbit=new Rabbit();
	Deer deer=new Deer();
	Elephant elephant=new Elephant();
	Athulya athulya=new Athulya();
	ForestControl forest=new ForestControl();
	Scanner scan=new Scanner(System.in);
	public void gaming()
	{
		forest.setForest();
	    tiger.create();
		lions.add(lion);
		//lions.add(lion);
		lions.get(0).create();
		//lions.get(1).create();
		
		rabbit.create();
		deer.create();
		elephant.create();
		athulya.create();
		forest.setAnimalLocation(lions.get(0));
		//forest.setAnimalLocation(lions.get(1));
		forest.setAnimalLocation(tiger);
	    forest.setAnimalLocation(athulya);
		forest.setAnimalLocation(elephant);
		forest.setAnimalLocation(rabbit);
		forest.setAnimalLocation(deer);
		System.out.println("-------------------------!!!!!!!!!!!!!!!!!!!!!!!Welcome to jungle!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-------------------");
		space=scan.nextLine();
		System.out.println("Let's just walk through the forest");
		space=scan.nextLine();
		System.out.println("\t\t\t\tLion-\tLion the king of beasts\n");
		space=scan.nextLine();
		System.out.println("\t\t\t\tTiger-\tA Tiger does not shout its tigritude, it acts\n");
		space=scan.nextLine();
		System.out.println("\t\t\t\tAthulya-\tThe animal born to define the word 'Fear'\n ");
		space=scan.nextLine();
		System.out.println("\t\t\t\tElephant-\tNature's greatest masterpiece, an Elephant\n");
		space=scan.nextLine();
		System.out.println("\t\t\t\tRabbit-\tFights with  brain not with size\n");
		space=scan.nextLine();
		System.out.println("\t\t\t\tDeer-\tCatch me if you can\n");
		space=scan.nextLine();
		System.out.println("\tNow select your fighter\n");
		System.out.println("...........................let's Rockkkkkkkkk");
		System.out.println("(1-Tiger,2-Lion,3-Rabbit,4-Deer,5-Elephant,6-Athulya)");
		animalCount=scan.nextInt();
		animalLocation(animalCount);
		
		
		fighterlife=forest.getfighterLife();
		
		while(fighterlife==1&&forest.getanimalCount()!=-1)
				{
					System.out.println("\tEnter the cordinates of selected animal\n");
					raw=scan.nextInt();
					column=scan.nextInt();
		
					animalObject1=setanimalFight(animalCount);
					distance(raw,column);
					
					if(forest.getanimalCount()!=-1)
					{
					System.out.println("Nearest animal name is="+animalName);
					System.out.println("Nearest animal distance is="+smallestDistance);
					animalObject2=getAnimal(animalName);
					forest.animalFight(animalObject1,animalObject2);
					fighterlife=forest.getfighterLife();
					forest.getForeststatus();
					space=scan.nextLine();
					}
		
				}
				if(fighterlife!=1)
				{
					System.out.println(" yogaillya amminiye....... paya madikkiyolin!!!!(Sorry your fighter is dead)");
				}
		}
	
	 void animalLocation(int animalCount)
	 {
		
		if(animalCount==2)
		{forest.getanimallocation(lion);}
		if(animalCount==1)
		{forest.getanimallocation(tiger);}
		if(animalCount==3)
		{forest.getanimallocation(rabbit);}
		if(animalCount==4)
		{forest.getanimallocation(deer);}
		if(animalCount==5)
		{forest.getanimallocation(elephant);}
		if(animalCount==6)
		{forest.getanimallocation(athulya);}
	 }
	 void distance(int r,int c)
	 {  
		forest.setDistance(r,c);
		distance=forest.getDistance();
	    name=forest.getAnimalName();
		if(forest.getanimalCount()!=-1)
		{
	    smallestDistance=distance[0];
		animalName=name[0];
		for(int j=1;j<forest.getanimalCount();j++)
		{
			if(smallestDistance<=distance[j])
			{
			}
			else
			{
				smallestDistance=distance[j];
				animalName=name[j];
			}
		}
		}
		else
		{System.out.println("polich muthe ijjj jayich");
	
		}
		
		for(int i=0;i<forest.getanimalCount();i++)
		{
		//System.out.println("Name="+name[i]);
		//System.out.println("Distance="+distance[i]);
		}
		
		
		
	 }
	  Animal setanimalFight(int animalNo)
	 {
		animalCount=animalNo;
		if(animalCount==1)
		{animalOne=tiger;}
		if(animalCount==2)
		{animalOne=lion;}
		if(animalCount==3)
		{animalOne=rabbit;}
		if(animalCount==4)
		{animalOne=deer;}
		if(animalCount==5)
		{animalOne=elephant;}
		if(animalCount==6)
		{animalOne=athulya;}
	return animalOne;
	 }
	Animal getAnimal(String animalName)
	{	
      if(animalName=="lion")
	  {animal=lions.get(0);
	  }
	  if(animalName=="Tiger")
	  {animal=tiger;
	  }
	   if(animalName=="Athulya")
	  {animal=athulya;
	  }
	  if(animalName=="Rabbit")
	  {animal=rabbit;
	  }
	   if(animalName=="Elephant")
	  {animal=elephant;
	  }
	   if(animalName=="Deer")
	  {animal=deer;
	  }
	  return animal;
	}
	
}