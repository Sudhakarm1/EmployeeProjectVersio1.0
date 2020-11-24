package org.jsp.Employee;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
public class Employee 
{
	public void Insert() throws Exception
	{
		Scanner Sc=new Scanner(System.in);
		Connection Con=null;
		PreparedStatement Ptsm=null;
		Properties Pro=new Properties();
		try
		{
			Pro.load(new FileReader(new File("./src/Test.Properties")));
			Class.forName(Pro.getProperty("driver"));
			Con=DriverManager.getConnection(Pro.getProperty("str2"),Pro);
			Ptsm=Con.prepareStatement("INSERT INTO Employee VALUES (?,?,?,?)");
			System.out.println("Enter Length");
			int Length=Sc.nextInt();
			for(int i=0;i<Length;i++)
			{
				System.out.println("Enter Id");
				int Id=Sc.nextInt();
				System.out.println("Enter Fname");
				String Fname=Sc.next();
				System.out.println("Enter Lname");
				String Lname=Sc.next();
				System.out.println("Enter Salary");
				double Sal=Sc.nextDouble();
				Ptsm.setInt(1,Id);
				Ptsm.setString(2, Fname);
				Ptsm.setString(3, Lname);
				Ptsm.setDouble(4, Sal);
				int num=Ptsm.executeUpdate();
			}
		}
		catch (SQLException y)
		{
			y.getMessage();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			Ptsm.close();
			Con.close();
		}
	}
}