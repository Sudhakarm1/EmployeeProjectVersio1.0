package org.jsp.Employee;
public class SeleectEmployee 
{
	public static void main(String[] args) 
	{
		Employee Emp=new Employee();
		SelectAverage SA=new SelectAverage();
		SelectData SD=new SelectData();
		try
		{
			//Emp.Insert();
			double AvgSal=SA.SelectAvr();
			System.out.println(AvgSal);
			SD.SelectDetail(AvgSal);
			SD.Update();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
