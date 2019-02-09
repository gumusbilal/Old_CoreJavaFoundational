package com.lxisoft.animalgame.forest;
import com.lxisoft.animalgame.animal.*;
import com.lxisoft.animalgame.animal.carnivores.*;
import com.lxisoft.animalgame.animal.herbivores.*;
import com.lxisoft.animalgame.animal.omnivore.*;
import java.util.ArrayList;
public class Forest{
	private int area = 50;
	private ArrayList<Animal> animals;
	private Hunter hunter;
	private int[] pitLocationX = new int[4];
	private int[] pitLocationY = new int[4];
	public void setAnimal(ArrayList<Animal> animals){
		this.animals = animals;
	}
	public ArrayList<Animal> getAnimal(){
		return animals;
	}
	public void setHunter(Hunter hunter){
		this.hunter = hunter;
	}
	public Hunter getHunter(){
		return hunter;
	}
	public Forest(){
		hunter = new Hunter();
		animals = new ArrayList<Animal>();
		for(int i=0;i<((int)(Math.random()*5)+5);i++){
			animals.add(new Tiger());
			animals.get(animals.size()-1).setName("Tiger "+(i+1));
			animals.get(animals.size()-1).setSpeed(6);
		}
		for(int i=0;i<((int)(Math.random()*5)+5);i++){
			animals.add(new Lion());
			animals.get(animals.size()-1).setName("Lion "+(i+1));
			animals.get(animals.size()-1).setSpeed(6);
		}
		for(int i=0;i<((int)(Math.random()*5)+5);i++){
			animals.add(new Bear());
			animals.get(animals.size()-1).setName("Bear "+(i+1));
			animals.get(animals.size()-1).setSpeed(5);
		}
		for(int i=0;i<((int)(Math.random()*5)+5);i++){
			animals.add(new Deer());
			animals.get(animals.size()-1).setName("Deer "+(i+1));
			animals.get(animals.size()-1).setSpeed(4);
		}
		for(int i=0;i<((int)(Math.random()*5)+5);i++){
			animals.add(new Rabbit());
			animals.get(animals.size()-1).setName("Rabbit "+(i+1));
			animals.get(animals.size()-1).setSpeed(2);
		}
		for(int i=0;i<((int)(Math.random()*5)+5);i++){
			animals.add(new Zebra());
			animals.get(animals.size()-1).setName("Zebra "+(i+1));
			animals.get(animals.size()-1).setSpeed(3);
		}
			animals.add(hunter);
			hunter.setName("Hunter");
			hunter.setSpeed(4);
			for(Animal test : animals){
				test.setLocationX((int)(Math.random()*area));
				test.setLocationY((int)(Math.random()*area));
			}
			for(int i=0;i<4;i++){
				pitLocationX[i] = (int)(Math.random()*50);
				pitLocationY[i] = (int)(Math.random()*50);
			}
			
	}
	public void startFight(){
		/*for(Animal test : animals){
			System.out.println(test.getName()+" "+test.getStrength()+" "+test.getLocationX()+" "+test.getLocationY());	
		}
		for(int i = 0;i<4;i++){
			System.out.println(pitLocationX[i]+" "+pitLocationY[i]);	
		}*/
		for(int i = 0 ;i<animals.size();i++){
			int randomAnimal = (int)(Math.random()*animals.size());
				if(Math.abs(animals.get(randomAnimal).getLocationX()-animals.get(i).getLocationX())<10 && Math.abs(animals.get(i).getLocationY()-animals.get(randomAnimal).getLocationY())<10){
					if(animals.get(randomAnimal) instanceof Herbivore && animals.get(i) instanceof Herbivore){
						herbivoreFight(animals.get(randomAnimal),animals.get(i));
					}
					else if(animals.get(randomAnimal) instanceof Carnivore && animals.get(i) instanceof Carnivore){
						carnivoreFight(animals.get(randomAnimal),animals.get(i));
					}
					else if(animals.get(randomAnimal) instanceof Carnivore && animals.get(i) instanceof Herbivore){
						carnivoreHerbivoreFight(animals.get(randomAnimal),animals.get(i));
					}
					else if(animals.get(randomAnimal) instanceof Herbivore && animals.get(i) instanceof Carnivore){
						carnivoreHerbivoreFight(animals.get(i),animals.get(randomAnimal));
					}
					else if(animals.get(randomAnimal) instanceof Omnivore && animals.get(i) instanceof Carnivore){
						carnivoreOmnivoreFight(animals.get(i),animals.get(randomAnimal));
					}
					else if(animals.get(randomAnimal) instanceof Carnivore && animals.get(i) instanceof Omnivore){
						carnivoreOmnivoreFight(animals.get(randomAnimal),animals.get(i));
					}
					else if(animals.get(randomAnimal) instanceof Omnivore && animals.get(i) instanceof Herbivore){
						herbivoreOmnivoreFight(animals.get(i),animals.get(randomAnimal)); 
					}
					else if(animals.get(randomAnimal) instanceof Herbivore && animals.get(i) instanceof Omnivore){
						herbivoreOmnivoreFight(animals.get(randomAnimal),animals.get(i));
					} 
				}
			}
		if(area>5){
		area = area - 5;
		}
		locationSetter();
	}
	public void pit(){
		
	}
	public void locationSetter(){
		int oldX;
		int newX;
		int oldY;
		int newY;
		for(int a=0;a<animals.size();a++){
		if(animals.get(a).getLocationX()<25){
			oldX = animals.get(a).getLocationX();
			newX = animals.get(a).getLocationX()+animals.get(a).getSpeed();
			animals.get(a).setLocationX(newX);
		}
		else{
			oldX = animals.get(a).getLocationX();
			newX = animals.get(a).getLocationX()-animals.get(a).getSpeed();
			animals.get(a).setLocationX(newX);
		}
		if(animals.get(a).getLocationY()<25){
			oldY = animals.get(a).getLocationY();
			newY = animals.get(a).getLocationY()+animals.get(a).getSpeed();
			animals.get(a).setLocationY(newY);
		}
		else{
			oldY = animals.get(a).getLocationY();
			newY = animals.get(a).getLocationY()-animals.get(a).getSpeed();
			animals.get(a).setLocationY(newY);
		}
			for(int i=0;i<4;i++){
				if(oldX<oldY&&newX<newY){
				for(int k=oldX;k<=newX;k++){
					for(int l=oldY;l<=newY;l++){
						if(k==pitLocationX[i] && l==pitLocationY[i]){
							System.out.println(animals.get(a).getName()+" Died By Falling From Hieght");
							animals.remove(animals.get(a));
						}
					}
				}
				}
				if(oldX>oldY&&newX>newY){
				for(int k=newX;k<=oldX;k++){
					for(int l=newY;l<=oldY;l++){
						if(k==pitLocationX[i] && l==pitLocationY[i]){
							System.out.println(animals.get(a).getName()+" Died By Falling From Hieght");
							animals.remove(animals.get(a));
						}
					}
				}
				}
				if(oldX<oldY&&newX>newY){
				for(int k=oldX;k<=newX;k++){
					for(int l=newY;l<=oldY;l++){
						if(k==pitLocationX[i] && l==pitLocationY[i]){
							System.out.println(animals.get(a).getName()+" Died By Falling From Hieght");
							animals.remove(animals.get(a));
						}
					}
				}
				}
				if(oldX>oldY&&newX<newY){
				for(int k=newX;k<=oldX;k++){
					for(int l=oldY;l<=newY;l++){
						if(k==pitLocationX[i] && l==pitLocationY[i]){
							System.out.println(animals.get(a).getName()+" Died By Falling From Hieght");
							animals.remove(animals.get(a));
						}
					}
				}
				}
			}
		}
		
	}
	public void herbivoreFight(Animal animalOne,Animal animalTwo){
		locationSetter();
		if(animalOne != animalTwo)
		if(animalOne.getSpeed()<3){
			System.out.println(animalOne.getName()+" Died In Fire");
			animals.remove(animalOne);
		}
		else if(animalTwo.getSpeed()<3){
			System.out.println(animalTwo.getName()+" Died In Fire");
			animals.remove(animalTwo);
		}
		else{
			System.out.println(animalOne.getName()+" And "+animalTwo.getName()+" Won't Fight");
		}				
	}
	public void carnivoreFight(Animal animalOne,Animal animalTwo){
		locationSetter();
		if(animalOne != animalTwo)
			if(animalTwo.getStrength()>animalTwo.getStrength()){
				System.out.println(animalOne.getName()+((Carnivore)animalOne).kills(animalTwo.getName()));
				//System.out.println(animalOne.sound());
				animalOne.setLocationX(animalTwo.getLocationX());
				animalOne.setLocationY(animalTwo.getLocationY());
				animals.remove(animalTwo);
				animalOne.setStrength(animalOne.getStrength()-5);
				animalOne.setHunger(animalOne.getHunger()+5);
			}
			else{
				System.out.println(animalTwo.getName()+((Carnivore)animalTwo).kills(animalOne.getName()));
				//System.out.println(animalTwo.sound());
				animalTwo.setLocationX(animalOne.getLocationX());
				animalTwo.setLocationY(animalOne.getLocationY());
				animals.remove(animalOne);
				animalTwo.setStrength(animalTwo.getStrength()-5);
				animalTwo.setHunger(animalTwo.getHunger()+5);
			}
	}
	public void carnivoreHerbivoreFight(Animal animalOne,Animal animalTwo){
		locationSetter();
		if(((Herbivore)animalTwo).luck()>75 ){
			System.out.println(animalTwo.getName()+" Escaped From "+animalOne.getName());
			}
		else if(animalTwo.getSpeed()>animalOne.getSpeed()){
			System.out.println(animalTwo.getName()+" Run Away From "+animalOne.getName());
		}
		else if(animalOne.getHunger()>50){
			System.out.println(animalOne.getName()+animalOne.eat(animalTwo.getName()));
			//System.out.println(animalOne.sound());
			animalOne.setLocationX(animalTwo.getLocationX());
			animalOne.setLocationY(animalTwo.getLocationY());
			animals.remove(animalTwo);
			animalOne.setStrength(animalOne.getStrength()+5);
			animalOne.setHunger(animalOne.getHunger()-5);
		}
		else{
			System.out.println(animalOne.getName()+((Carnivore)animalOne).kills(animalTwo.getName()));
			//System.out.println(animalOne.sound());
			animalOne.setLocationX(animalTwo.getLocationX());
			animalOne.setLocationY(animalTwo.getLocationY());
			animals.remove(animalTwo);
			animalOne.setStrength(animalOne.getStrength()-5);
			animalOne.setHunger(animalOne.getHunger()+5);
			}
	}
	public void carnivoreOmnivoreFight(Animal animalOne,Animal animalTwo){
		locationSetter();
		if(animalOne.getStrength()>90){
			System.out.println(animalOne.getName()+((Carnivore)animalOne).kills(animalTwo.getName()));
			//System.out.println(animalOne.sound());
			animalOne.setLocationX(animalTwo.getLocationX());
			animalOne.setLocationY(animalTwo.getLocationY());
			animals.remove(animalTwo);
			animalOne.setStrength(animalOne.getStrength()-5);
			animalOne.setHunger(animalOne.getHunger()+5);
		}
		else if(animalOne.getSpeed()>50){
			System.out.println(animalOne.getName()+" Run Away From "+animalTwo.getName());
		}
		else if(((Hunter)animalTwo).getBullets()!= 0){
			System.out.println(animalTwo.getName()+((Omnivore)animalTwo).hunt(animalOne.getName()));
			((Hunter)animalTwo).setBullets(((Hunter)animalTwo).getBullets()-1);
			//System.out.println(animalTwo.sound());
			animalTwo.setLocationX(animalOne.getLocationX());
			animalTwo.setLocationY(animalOne.getLocationY());
			animals.remove(animalOne);
		}
		else if(((Hunter)animalTwo).getBullets()== 0){
			if(((Omnivore)animalTwo).luck()>80){
				System.out.println(animalTwo.getName()+" Escaped From "+animalOne.getName());
			}
			else{
				System.out.println(animalOne.getName()+((Carnivore)animalOne).kills(animalTwo.getName()));
				//System.out.println(animalOne.sound());
				animalOne.setLocationX(animalTwo.getLocationX());
				animalOne.setLocationY(animalTwo.getLocationY());
				animals.remove(animalTwo);
				animalOne.setStrength(animalOne.getStrength()-5);
				animalOne.setHunger(animalOne.getHunger()+5);
			}
		}
	}
	public void herbivoreOmnivoreFight(Animal animalOne,Animal animalTwo){
		locationSetter();
		if(((Herbivore)animalOne).luck()>75 ){
			System.out.println(animalOne.getName()+" Escaped From "+animalTwo.getName());
		}
		else if(animalOne.getSpeed()>50){
			System.out.println(animalOne.getName()+" Run Away From "+animalTwo.getName());
		}
		else if(((Hunter)animalTwo).getBullets()!= 0){
			System.out.println(animalTwo.getName()+((Omnivore)animalTwo).hunt(animalOne.getName()));
			((Hunter)animalTwo).setBullets(((Hunter)animalTwo).getBullets()-1);
			//System.out.println(animalTwo.sound());
			animalTwo.setLocationX(animalOne.getLocationX());
			animalTwo.setLocationY(animalOne.getLocationY());
			animals.remove(animalOne);
		}
		else if(((Hunter)animalTwo).getBullets()== 0){
			System.out.println(animalTwo.getName()+" Leaves "+animalOne.getName());
		}
	}
	public void winner(){
		for(Animal test : animals){
		System.out.println("\n"+"*****"+test.getName()+" Wins*****");
		}
	}
}