public class Animal{
	int strength;
	int hunger;
	boolean isAlive=true;
	public void setIsAlive(boolean a)
	{
		this.isAlive=a;
	}
	
	public boolean getIsAlive()
	{
		return isAlive;
	}
	
	public void Eat()
	{
		System.out.println("eating");
	}
	public void Sound()
	{
		System.out.println("making sound");
	}
	public void setStrength(int a)
	{

		this.strength=a;
	}
	
	public void setHunger(int b)
	{
		this.hunger=b;
	}

	
	public int getStrength()
	{
		return strength;
	}
	
	public int getHunger()
	{
		return hunger;
	}
	
}
