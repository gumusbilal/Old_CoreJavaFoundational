package com.lxisoft.forestv4.animal;
import java.util.ArrayList;
public class Bear extends Animal implements Carnivore
{
	public int kill()
	{
		int killFactor=(int)(Math.random()*100);
		return killFactor;	
	}
	

}