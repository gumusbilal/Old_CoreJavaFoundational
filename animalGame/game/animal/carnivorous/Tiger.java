package com.lxisoft.animalGame.game.animal.carnivorous;
 import com.lxisoft.animalGame.game.animal.Animal;
 import com.lxisoft.animalGame.game.animal.AnimalLevel;
 import java.util.*;
public class Tiger extends Animal implements Carnivorous 
{
	AnimalLevel level=new AnimalLevel();
	
	public void eat()
	{
		level.settingLevel();
	}

	
	
	
	
}