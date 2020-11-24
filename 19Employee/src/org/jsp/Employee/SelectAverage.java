package org.jsp.Employee;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class SelectAverage
{
     private double AvgSal; 
	public double SelectAvr() throws Exception
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
		    R=Ptsm.executeQuery("SELECT AVG(Salary) from Employee");
		    if(R.next())
		    {
		    	AvgSal=R.getDouble(1);
		    }
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
		return AvgSal;
	}
}