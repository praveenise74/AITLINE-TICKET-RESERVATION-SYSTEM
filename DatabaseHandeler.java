package praveen.airline;
import java.sql.*;

public class DatabaseHandeler {
	
	public boolean insertData(String user, String pass)
	{
		boolean flag = false;
	try{  
		//step1 load the driver class  
		Class.forName("com.mysql.jdbc.Driver");  
		  
		//step2 create  the connection object  
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/airline","root","");    
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from users");  
		/*int id=11;
		String name="Ram";
		int age=20;
		String query = "insert into emp values("+id+",'"+name+"',"+age+");";
		int value = stmt.executeUpdate(query);*/
		while(rs.next()) 
		{
			String id = rs.getString(1);
			String passwd = rs.getString(4);
			if(id.equals(user) && passwd.equals(pass))
				flag=true;  
		}
		/*if(value == 1)
			flag=true;*/
		  
		//step5 close the connection object  
		con.close(); 
		  
		}
	catch(Exception e){ System.out.println(e);}
	return flag;  
	}
		  
}
