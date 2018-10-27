package com.lxisoft.jdbcproject;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
class CustomerController
{
	public static void main(String[] args)
	{ 
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerlogin","root","root");
			
		
			Statement stmt=con.createStatement();
			String query="select * from customerdetails";
			
			ResultSet set =stmt.executeQuery(query);
			while(set.next())
			{
				System.out.println(set.getInt(1) +"\t"+set.getString(2));
			}
				
			
		}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			catch(Exception e)
			{
				System.out.println(e);
			}
				
	}
}
		
		
