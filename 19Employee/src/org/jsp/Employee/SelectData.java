package org.jsp.Employee;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
public class SelectData 
{
	public void display() throws Exception
	{
		Connection Con=null;
		Statement Ptsm=null;
		Properties Pro=new Properties();
		ResultSet R=null;
		try
		{
			Pro.load(new FileReader(new File("./src/Test.Properties")));
			Class.forName(Pro.getProperty("driver"));
			Con=DriverManager.getConnection(Pro.getProperty("str2"),Pro);
		    Ptsm=Con.createStatement();
		    R=Ptsm.executeQuery("SELECT * from Employee");
		    System.out.println("E_ID"+"\t\t"+"E_FNAME"+"\t\t"+"E_LNAME"+"\t\t"+"E_SALARY");
		    System.out.println("-------------------------------------------------------------");
		    while(R.next())
		    {
		    	System.out.println(R.getInt(1)+"\t\t"+R.getString(2)+"\t\t"+R.getString(3)+"\t\t"+R.getDouble(4));
		    }
		    System.out.println("-------------------------------------------------------------");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			R.close();
			Ptsm.close();
			Con.close();
		}
	}
		
	public void SelectDetail(double AvgSal) throws Exception
	{
		double avgsal=AvgSal;
		Connection Con=null;
		Statement Ptsm=null;
		Properties Pro=new Properties();
		ResultSet R=null;
		try
		{
			Pro.load(new FileReader(new File("./src/Test.Properties")));
			Class.forName(Pro.getProperty("driver"));
			Con=DriverManager.getConnection(Pro.getProperty("str2"),Pro);
		    Ptsm=Con.createStatement();
		    R=Ptsm.executeQuery("SELECT * from Employee WHERE Salary>=(SELECT AVG(Salary) from Employee)");
		    System.out.println("E_ID"+"\t\t"+"E_FNAME"+"\t\t"+"E_LNAME"+"\t\t"+"E_SALARY");
		    System.out.println("-------------------------------------------------------------");
		    while(R.next())
		    {
		    	System.out.println(R.getInt(1)+"\t\t"+R.getString(2)+"\t\t"+R.getString(3)+"\t\t"+R.getDouble(4));
		    }
		    System.out.println("-------------------------------------------------------------");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			R.close();
			Ptsm.close();
			Con.close();
		}
	}
	public void Update() throws Exception
	{
		Connection Con=null;
		Statement Ptsm=null;
		Properties Pro=new Properties();
		//ResultSet R=null;
		try
		{
			Pro.load(new FileReader(new File("./src/Test.Properties")));
			Class.forName(Pro.getProperty("driver"));
			Con=DriverManager.getConnection(Pro.getProperty("str2"),Pro);
		    Ptsm=Con.createStatement();
		    Ptsm.executeUpdate("UPDATE Employee SET Salary=220000 WHERE Salary>=110000 AND LASTNAME='m'");
		    /*System.out.println("E_ID"+"\t\t"+"E_FNAME"+"\t\t"+"E_LNAME"+"\t\t"+"E_SALARY");
		    System.out.println("-------------------------------------------------------------");
		    while(R.next())
		    {
		    	System.out.println(R.getInt(1)+"\t\t"+R.getString(2)+"\t\t"+R.getString(3)+"\t\t"+R.getDouble(4));
		    }*/
		    System.out.println("UPADTED EMPLOYEE TABLE:");
		    System.out.println("=======================");
           display();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//R.close();
			Ptsm.close();
			Con.close();
		}
	}
}