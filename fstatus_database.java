package praveen.airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class fstatus_database {
	String flight_id =null;
	String source = null;
	String destination = null;
	String hours = null;
	long distance = 0;
	String day = null;
	ResultSet rs=null;
	public Connection conn() throws ClassNotFoundException, SQLException
	{System.out.println("working at fsataus func.");
		
	
			Class.forName("com.mysql.jdbc.Driver");  
			 Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/airline","root","");
			 return con;
		}
		public void fstatus(String Source,String Destination,String Day) throws SQLException, ClassNotFoundException
		{	Connection con=conn();	  
			Statement stmt=con.createStatement();  
			  
			   rs=stmt.executeQuery("select * from flights where source='"+Source+"' and destination='"+Destination+"' and day='"+Day+"'");
			  
			  rs.next();
			   flight_id=rs.getString(1);
			   source=rs.getString(2);
			   destination=rs.getString(3);
			   hours=rs.getString(4);
			   distance=rs.getLong(5);
			   day=rs.getString(6);
			  
			  System.out.println(""+flight_id+"	"+source+"	"+destination+"		"+hours+"		"+distance+"	"+day);
			  con.close();
			 	
	}
		public void flightid(String Flight_id) throws ClassNotFoundException, SQLException
		{
			Connection con=conn();	  
			Statement stmt=con.createStatement();  
			  
			   rs=stmt.executeQuery("select * from flights where flight_id='"+Flight_id+"'");
			  
			  rs.next();
			   flight_id=rs.getString(1);
			   source=rs.getString(2);
			   destination=rs.getString(3);
			   hours=rs.getString(4);
			   distance=rs.getLong(5);
			   day=rs.getString(6);
			  
			  System.out.println(""+flight_id+"	"+source+"	"+destination+"		"+hours+"		"+distance+"	"+day);
			  con.close();
		}
		

	}


