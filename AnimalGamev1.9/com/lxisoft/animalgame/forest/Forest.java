package com.lxisoft.animalgame.forest;
import com.lxisoft.animalgame.men.Hunter;
import com.lxisoft.animalgame.animal.*;
import com.lxisoft.animalgame.interfaces.*;
import com.lxisoft.animalgame.exceptions.*;
import java.io.*;
import java.util.*;
public class Forest{
	int xloc,yloc;
	private static Animal[][] a=new Animal[20][20];
	private static Zebra[] Z=new Zebra[20];
	private static Tiger[] T=new Tiger[20];
	private static Lion[] L=new Lion[20];
	private static Deer[] D=new Deer[20];
	private static Rabbit[] R= new Rabbit[20];
    Hunter h=new Hunter();
	Random r=new Random();
	private int f=0,sur=0;
	//constructor(forest);initiallizing all the objects.
	public Forest() throws DeadException{
		for(int i=0;i<7;i++){
			for(int j=0;j<7;j++){
				a[i][j]=null;
			}
		}
		for(int i=0;i<4;i++){
			L[i]=new Lion(i);
			 findLoc(L[i]);
		}
		
		for(int i=0;i<5;i++){
			R[i]=new Rabbit(i);
			 findLoc(R[i]);
		}
		for(int i=0;i<6;i++){
			T[i]=new Tiger(i);
			 findLoc(T[i]);
		}
		findLoc(h);
	}
	//Constructor overloading happens here.
	public Forest(int zebra,int deer)throws DeadException{
	    this();
		for(int i=0;i<zebra;i++){
			Z[i]=new Zebra(i);
			 findLoc(Z[i]);
		}
		for(int i=0;i<deer;i++){
			D[i]=new Deer(i);
			 findLoc(D[i]);
		}
		outGrid();
		for(int i=0;i<4;i++){
			canFight(L[i]);
		}
		for(int i=0;i<6;i++){
			canFight(T[i]);
		}
		canFight(h);
		
	  }
	 //checking whether an Animal can Roam or not.
	public boolean check(Animal c){
		if((c.getStrength()>5)&&(c.getHungry()>5)&&(a[c.getXloc()][c.getYloc()]!=null)){
			return true;
		}
		return false;
	}
	 public void findLoc(Animal b){
    do{  
		b.setXloc(r.nextInt(7));
		b.setYloc(r.nextInt(7));
		
	}while((a[b.getXloc()][b.getYloc()]!=null)&&(a[b.getXloc()][b.getYloc()]!=b));
	a[b.getXloc()][b.getYloc()]=b;
    }
	
	public void nearBy(Animal c,Animal h){
	int minx=c.getXloc()-c.getReach();
	int miny=c.getYloc()-c.getReach();
	int maxx=c.getXloc()+c.getReach();
	int maxy=c.getYloc()+c.getReach();
	do{
		h.setXloc(r.nextInt(7));
		h.setYloc(r.nextInt(7));
	}while(h.getXloc()>minx && h.getXloc()<maxx && h.getYloc()>miny && h.getYloc()<maxy && (a[h.getXloc()][h.getYloc()]!=null)&&(a[h.getXloc()][h.getYloc()]!=h));
	a[h.getXloc()][h.getYloc()]=h;
}
	//checking whether an animal can fight with other animals.
	public void canFight(Animal c)throws DeadException{
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{    try{if(a[i][j]==null)
						throw new DeadException();
				if((check(c))&&(a[i][j]!=c)&&(Math.abs(c.getXloc()-i)<=c.getReach())&&(c instanceof Carnivorus)&&(Math.abs(c.getYloc()-j)<=c.getReach())){
					
					if((c.getStrength()>a[i][j].getStrength())&&(a[i][j].getLuck()<2)&&(c.breathlevel())&&(c.getName()!="HUNTER")){
						
						fightcast1(c,a[i][j]);
						a[i][j]=null;
						}
					else if((c.getName()=="HUNTER")&&(c.getStrength()>a[i][j].getStrength())&&(a[i][j].getLuck()<2)){
						HunterCast1(c,a[i][j]);
						a[i][j]=null;	
						}
					else if((c.getName()=="HUNTER")&&(c.getStrength()<a[i][j].getStrength())&&(a[i][j].getLuck()<2)){
						HunterCast2(c,a[i][j]);
						a[c.getXloc()][c.getYloc()]=null;	
						}
				    else if(a[i][j] instanceof Herbivorus &&(a[i][j].getLuck()>2))
					{  
						runawaycast(c,a[i][j]);
						nearBy(c,a[i][j]);
						a[i][j]=null;
					}
				    else{
						figthcast2(c,a[i][j]);
						a[c.getXloc()][c.getYloc()]=null;
				    }
			}}catch(DeadException e){}
			}
		}
		
		
	}
	public void HunterCast1(Animal c,Animal a){
		if(c instanceof Hunter){
			            ((Hunter)c).fight(c,a);//casting
		                ((Hunter)c).killed(c,a);//casting
		}
		
	}
	public void HunterCast2(Animal c,Animal a){
		if(c instanceof Hunter){
			            ((Hunter)c).fight(c,a);//casting
		                ((Hunter)c).killed(a,c);//casting
		}
		
	}
	public void fightcast1(Animal c,Animal a){
		if(c instanceof Lion){
						((Lion)c).fight(c,a);//casting
		                ((Lion)c).eats(c,a);//casting
						}
		if(c instanceof Tiger){
						((Tiger)c).fight(c,a);//casting
		                ((Tiger)c).eats(c,a);//casting
					    }
		
	}
	
	public void runawaycast(Animal c,Animal a){
		if(c instanceof Lion){
					((Lion)c).fight(c,a);//casting
					
					if(a instanceof Deer){
						((Deer)a).runaway(a);//casting
					}
					if(a instanceof Zebra){
						((Zebra)a).runaway(a);//casting
					}
					if(a instanceof Rabbit){
						((Rabbit)a).runaway(a);//casting
					}
                        }					
		if(c instanceof Tiger){
						((Tiger)c).fight(c,a);//casting
						
					if(a instanceof Deer){
						((Deer)a).runaway(a);//casting
					}
					if(a instanceof Zebra){
						((Zebra)a).runaway(a);//casting
					}
					if(a instanceof Rabbit){
						((Rabbit)a).runaway(a);//casting
					}
						}
		if(c instanceof Hunter){
						((Hunter)c).fight(c,a);//casting
						
					if(a instanceof Deer){
						((Deer)a).runaway(a);//casting
					}
					if(a instanceof Zebra){
						((Zebra)a).runaway(a);//casting
					}
					if(a instanceof Rabbit){
						((Rabbit)a).runaway(a);//casting
					}
						}
						
	}
	
	public void figthcast2(Animal c,Animal a){
		if(c instanceof Lion){
			
							((Lion)c).fight(c,a);//casting
		                     ((Lion)c).eats(a,c);//casting
					         }
		if(c instanceof Tiger){
			
						      ((Tiger)c).fight(c,a);//casting
		                      ((Tiger)c).eats(a,c);//casting
					          }
	}
	//printing the current status of the forest.
	public void outGrid()
	{   
		for(int i=0;i<7;i++){
			for(int j=0;j<7;j++){
				if(a[i][j]!=null){
					System.out.print("\t"+a[i][j].getName()+"  ");
					f++;
				}
				else{
					System.out.print("\t0\t");
				}
			}
			System.out.println("\n\n\n");
		}
	}
	
	//shows the final status of the number of animals in the forest in words.	
	public void finalStatus(int z,int d){
		sur=Math.abs((16+z+d)-f);
		System.out.println("TOTAL INITIAL NUMBER OF ANIMALS "+(16+z+d));
		System.out.println("TOTAL NUMBER OF ANIMALS SURVIVED "+sur);
	}
	
	
}
