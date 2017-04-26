package praveen.airline;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class fbook_database {
	public boolean fbook(long pnr,String source_city, String destination_city,int numofperson,String sqldate,String day,String hours,long distance)
	{
		boolean flag=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/airline","root","");    
			  
			//Statement stmt=con.createStatement();
			 PreparedStatement preparedstatement=(PreparedStatement) con.prepareStatement("insert into tickets values(?,?,?,?,?,?,?,?)");
			 preparedstatement.setLong(1,pnr);
			 preparedstatement.setString(2,source_city);
			 preparedstatement.setString(3,destination_city);
			 preparedstatement.setInt(4,numofperson);
			 preparedstatement.setString(5,sqldate);
			 preparedstatement.setString(6,day);
			 preparedstatement.setString(7,hours);
			 preparedstatement.setLong(8,distance);
			 
			 int i=preparedstatement.executeUpdate();
			 if(i!=0)
			 flag=true;
			 con.close();
			 
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return flag;
	}
	

}
