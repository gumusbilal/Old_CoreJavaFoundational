package com.lxisoft.requirements;
import java.util.*;
public class Board
{


 int numbers[][]=new int[10][10];
public ArrayList<Ladder> ladders=new ArrayList<Ladder>();
public ArrayList<Snake> snakes=new ArrayList<Snake>();

Random r = new Random();

public void placeLadders()
{
	
for(int i=0;i<5;i++)
	{    
        
		int flag=0;
		int p,q;
		Ladder l=new Ladder();
		do{
			flag=0;
	         p=r.nextInt(95-78)+78;
		     q=r.nextInt(55-28)+28;
			 for(int k=0;k<ladders.size();k++){
			 if((ladders.get(k).getTop()==p)||(ladders.get(k).getBottom()==q)){
				 flag=1;
				 break;
			 }
			 }
		}while(flag==1);	
if(flag==0){
	l.setTop(p);
	
l.setBottom(q);
ladders.add(l);
		}
	}
	

/*		
for(int k=0;k<ladders.size();k++){
	System.out.println("\n");
System.out.println("T"+(k+1)+(" : ")+ladders.get(k).getTop()+("\n")+"B"+(k+1)+(" : ")+ladders.get(k).getBottom());
}*/	
}

public void placeSnakes()
{

for(int i=0;i<5;i++)
	{    
        
		int flag=0;
		int x,y;
		Snake s=new Snake();
		
		do{
			flag=0;
	         x=r.nextInt(77-56)+56;
		     y=r.nextInt(29-5)+5;
			 for(int k=0;k<snakes.size();k++){
			 if((snakes.get(k).getHead()==x)||(snakes.get(k).getTail()==y)){
				 flag=1;
				 break;
			 }
			 }
		}while(flag==1);	
if(flag==0){
	s.setHead(x);
    s.setTail(y);
snakes.add(s);
		}
	}
	

/*		
for(int k=0;k<snakes.size();k++){
	System.out.println("\n");
System.out.println("H"+(k+1)+(" : ")+snakes.get(k).getHead()+("\n")+"t"+(k+1)+(" : ")+snakes.get(k).getTail());
}*/	

}

public void display()
{
	System.out.println(ladders.size());
	for(int k=0;k<ladders.size();k++){
	System.out.println("\n");
System.out.println("T"+(k+1)+(" : ")+ladders.get(k).getTop()+("\n")+"B"+(k+1)+(" : ")+ladders.get(k).getBottom());
System.out.println("H"+(k+1)+(" : ")+snakes.get(k).getHead()+("\n")+"t"+(k+1)+(" : ")+snakes.get(k).getTail());

}
}

public void createBoard(ArrayList<Player> players)
{


              int x = 101;
			int  n=10;
			 
			 for(int i=0;i<10;i++)
			   {
			        for(int j=0;j<10;j++)
			           {
			               if(n%2==0)
			                 {
			                      x--;
			                      numbers[i][j]=x;
			                 }
			 
			               else
			                 {
			                      numbers[i][j]=x;
			                      x++;
			                 }
			           }
			        x=x-10;
			        n--;
			  }
			 
			 
			 
			int k=0;
			//placeSnakes();
			//placeLadders();
			
		for(int i=0;i<10;i++)
			 { 
			    for(int j=0;j<10;j++)
			      {
					  int m=0;
					  //int mx=0;
					  for(int r=0;r<players.size();r++)
					  {
						  if(numbers[i][j]==players.get(r).getPosition())
						  {
							 System.out.print("P"+(r+1)+"\t");
                         // mx=1;
						 m=1;
						  }
					  }
					  
					  
					  
					  for(k=0;k<snakes.size();k++)
					  {
						  
						  if((snakes.get(k).getHead())==(numbers[i][j]))
						  {
                      System.out.print("("+numbers[i][j]+")H"+(k+1)+"\t");
					 m=1;
						  }
						  else if((snakes.get(k).getTail())==(numbers[i][j]))
						  {
							System.out.print("("+numbers[i][j]+")T"+(k+1)+"\t");
                          m=1;
						  }
						  
						  else if((ladders.get(k).getTop())==(numbers[i][j]))
						  {
							System.out.print("["+numbers[i][j]+"]U"+(k+1)+"\t");
                            m=1;							
						  }
						  else if((ladders.get(k).getBottom())==(numbers[i][j]))
						  {
							System.out.print("["+numbers[i][j]+"]B"+(k+1)+"\t");
                            m=1;							
						  }
						 
						  else{
							//System.out.print(numbers[i][j]+"\t"); 
							//m=0;
						  }
						  
					  }
					  if(m==1)
					  {
						  
					  }
					  else
					 System.out.print(numbers[i][j]+"\t"); 
                  }
				  
                  System.out.println("\n");
             }


        
}			 

public void setBoard(ArrayList<Player> players)
{
	placeLadders();
	placeSnakes();
	createBoard(players);
}


}
