import java.util.*;
public class Animal
{
	String name;
	int animalStrength;
	int l1,l2,l3,i;
public void setName(String name)
{
	this.name=name;
}
public void setAnimalStrength(int animalStrength)
{
	this.animalStrength=animalStrength;
}
public String getName()
{
	return name;
}
public int getAnimalStrength()
{
	return animalStrength;
}
	public boolean fight(Animal animal)
	{
		
			
			System.out.println(name+ " and " +animal.name+ " are fighting ");
			if(animal instanceof Carnivores)
			{
				if(animalStrength>animal.animalStrength)
					{
						System.out.println(name+" WINS!... ");
						System.out.println(animal.name+" LOOSES!....");
						System.out.println("***************");
						return true;
					}
				else 
				{
					System.out.println(animal.name+" WINS!... ");
					System.out.println(name+" LOOSES!... ");
					System.out.println("***************");
					return false;
				}
			}
			return false;
	}
	public boolean eat(Animal animal)
	{

			if(animal instanceof Herbivores)
			{
				if(animalStrength>animal.animalStrength)
				{
					System.out.println(name+" Try to eat "+animal.name);
					System.out.println(name+" ate "+animal.name);
					System.out.println("***************");
					return true;
				}
				else 
				{
					System.out.println(name+" hunting "+animal.name);
					System.out.println(animal.name+" Escaped from "+name);
					animal.setAnimalStrength(animal.getAnimalStrength()-10);
					System.out.println(animal.name+" Ran away... ");
					System.out.println("****************");
					return false;
				}
			}
		return true;
	}
}



	