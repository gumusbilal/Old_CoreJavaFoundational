package com.lxisoft.hotel;
import com.lxisoft.admin.*;
import com.lxisoft.fooditem.*;
import com.lxisoft.customer.*;
import com.lxisoft.bill.*;
import java.util.*;
import java.io.*;
public class Hotel
{
Admin admin=new Admin();
Customer customer=new Customer();
public ArrayList<FoodItem> foodItems=new ArrayList<FoodItem>();

Scanner scan=new Scanner(System.in);

public void homePage()throws Exception
{
	int ch,y,price;
	Bill bill=new Bill();
	do
	{
		
		      System.out.println("  ");
			  System.out.println("1.ADMIN LOGIN");
			  System.out.println("2.FOOD MENU");
			  System.out.println("3.CUSTOMER LOGIN");
			  System.out.println("  ");
			  System.out.print("Enter your choice:");
			  ch=scan.nextInt();
			   switch(ch)
			  {
				  case 1:admin.logAdmin(foodItems);
				  break;
				  case 2:foodMenu();
				  break;
				  case 3:customer.logUser(foodItems);
				    price=admin.calculateBill(customer.item,customer.value,foodItems);
					bill.setTotalPrice(price);
					bill.viewBill(customer.item,customer.value,foodItems);
				  break;
				   default:System.out.println("Invalid choice made...please try again...!!!");
			
			  }
			  System.out.print("Do you want to continue...?Yes=1/No=0:");
			  y=scan.nextInt();
			}while(y==1);



}

	
	
	public void foodMenu()throws Exception
	{
		File s=new File("foodItems.txt");
		FileWriter fw=new FileWriter(s,true);
		BufferedWriter bw=new BufferedWriter(fw);
		
		
		FileReader fr=new FileReader(s);
		BufferedReader br=new BufferedReader(fr);
        String b=null;
		
		
	System.out.println(" ");
	System.out.println("                               FOOD MENU                               ");
	System.out.println("-----------------------------------------------------------------------");
	System.out.println("FoodItem                                                           Price");
	System.out.println("-----------------------------------------------------------------------");
	
	
		 
			 for(FoodItem f:foodItems)
		{
		bw.write(f.getName()+";"+f.getPrice());
		bw.newLine();
		}
        bw.close();	
		System.out.println("******************Old food*************");
		for(FoodItem fff:foodItems){
			
			System.out.println("********"+fff.getName());
		}
			 int i=0;
			 while((b=br.readLine())!=null)
			 {
				
				 System.out.println(">>>"+b);
				  String a[]=b.split(";");
				  foodItems.add(new FoodItem());
				  foodItems.get(i).setName(a[0]);
				  foodItems.get(i).setPrice(Integer.parseInt(a[1]));
				  i++;
			 }
	
	for(FoodItem f:foodItems)
	{
		
		System.out.println(f.getName()+"                                          "+f.getPrice());
	}
	}
	
	
}