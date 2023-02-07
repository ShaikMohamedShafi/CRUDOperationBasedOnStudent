package com.techpalle;

import java.sql.*;
import java.util.InputMismatchException;

public class Employee 
{

	private static final String url = "jdbc:mysql://localhost:3306/shafi";
	private static final String username = "root";
	private static final String password = "admin";
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	
	private static ResultSet rs = null;
	
	//1st Approach
	public static void creating()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			s = con.createStatement();
			
			String qry = "create table employee(eno int primary key auto_increment, "
					+ "ename varchar(40), esalary int)";
			s.executeUpdate(qry);
			
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLSyntaxErrorException e)
		{
			System.out.println("Table is already Exist");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	//2nd Approach
	public static void inserting(String ename ,int esalary)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			ps = con.prepareStatement("insert into employee(ename,esalary) values(?,?)");
			ps.setString(1, ename);
			ps.setInt(2, esalary);
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	//3rd Approach
	public static void update(int eno, String ename, int esalary)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			ps = con.prepareStatement("update employee set ename=?,esalary=? where eno=?");
			ps.setString(1, ename);
			ps.setInt(2, esalary);
			ps.setInt(3, eno);
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	//4th Approach
	public static void delete(int eno)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			ps = con.prepareStatement("delete from employee where eno=?");
			ps.setInt(1, eno);
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}