package com.techpalle;

import java.sql.SQLException;
import java.util.Scanner;

public class MyProgram 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Press the following numbers for CRUD operation\n"
				+ "Press 1 - To Create Table\n"
				+ "press 2 - To Insert a row into Table\n"
				+ "press 3 - To Update the Table\n"
				+ "press 4 - To Delete the Table\n"
				+ "press 5 - To Exit");
		int eno=0;
		String ename=null;
		int esalary=0;
		int num1=sc.nextInt();
		if(num1==1)
		{
			Employee.creating();
			System.out.println("<---Table is Created--->");
		}
		int num2=sc.nextInt();
		if(num2==2)
		{
			System.out.println("Enter ename in String and esalary in int");
			Employee.inserting(ename=sc.next(), esalary=sc.nextInt());
			Employee.inserting(ename=sc.next(), esalary=sc.nextInt());
			System.out.println("<---Values are Inserted--->");
		}
		int num3=sc.nextInt();
		if(num3==3)
		{
			System.out.println("Enter eno in int, ename in String and esalary in int");
			Employee.update(eno=sc.nextInt(), ename=sc.next(), esalary=sc.nextInt());
			System.out.println("<---Value Updated--->");
		}
		int num4=sc.nextInt();
		if(num4==4)
		{
			System.out.println("Enter eno in int to delete a row");
			Employee.delete(eno=sc.nextInt());
			System.out.println("<---Row Deleted--->");
		}
		int num5=sc.nextInt();
		if(num5==5)
		{
			System.out.println("<---Program was Exit--->");
			System.exit(0);
		}
	}
}