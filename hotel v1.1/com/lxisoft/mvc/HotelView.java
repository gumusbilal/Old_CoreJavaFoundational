package com.lxisoft.mvc;
import com.lxisoft.hotel.*;
import com.lxisoft.hotel.Admin;
import com.lxisoft.mvc.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class HotelView
{
	
	File f=new File("A.Txt");
	FileReader fr;
	BufferedReader br;
	Scanner scan=new Scanner(System.in);
	public void authendication(Admin admin,Cashier cashier,Customer customers,ArrayList<Food> foods)throws Exception
    {
	
	     System.out.println("do you want admin or cashier or customer\ncashier=0\nadmin=1\ncustomer=2\nworkers=3");
		 int login=scan.nextInt();
		 
		 if(login==1)	
		  {
			  System.out.println("enter the admin password");
			  int adminPassword=scan.nextInt();
			
			  if(adminPassword==1234)
					{      
						admin.choose(foods);
					}
			  else
					{
						System.out.println("not found");
					}
		  }
		 else if(login==0)
		  {
					System.out.println("enter cashier password");
					int cashierPassword=scan.nextInt();
					if(cashierPassword==7787)
					{
				      //cashier.callingBill(customers.orderedFood);
					  System.out.println("jjjjjjjjjjjjjjjjjjjj");
					
					}
					else
					{
						System.out.println("not founds");
					}
			}
		else if(login==2)
			{
				  // menuList.listOfFood(foods);
				   customers.foodChoosing(foods);
				
				   balanceFoodPrinting();
			}
       else if(login==3)
		    {   
			    
                System.out.println("do you want see the balance food details \n*)yes=1\n*)no=2");
			    int choice=scan.nextInt();
				if(choice==1)
				{
					balanceFoodPrinting();
				}
				else 
				{
					System.out.println("you cant see");
				}
			}
		else
			{
				System.out.println("not found");
			}
	 }
    
		
			public void balanceFoodPrinting()throws Exception
			{
				
		      
				String k;
				System.out.println("BALANCE FOOD\n**************");
		        
						fr=new FileReader(f);
						br=new BufferedReader(fr);
						int i=0;
						while((k=br.readLine())!= null)
						{	
					          
							String item[]=k.split(",");
							
							
							
							for(int j=0;j<3;j++)
							{
								
					          System.out.println(item[j]);
							 
						    }
					
						i++;
							
						}
				
			}
}