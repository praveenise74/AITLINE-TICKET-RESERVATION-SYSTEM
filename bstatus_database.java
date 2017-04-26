package praveen.airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class bstatus_database {
	
	
	 public int dbpnr=0;
	  String source=null;
	  String destination=null;
	  int numofperson=0;
	  String date=null;
	  String day="";
	  String hours="";
	  long distance=0;
	  int pnr1=0;
	  Connection con=null;
		
		ResultSet rs=null;
		ResultSet rs1=null;
		
		public void connection() throws ClassNotFoundException
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				 Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/airline","root","");
			} catch (SQLException e) {
				System.out.println("sql con  error");
				e.printStackTrace();
			} 
		}  
			public void bstatus(long pnr)
			{	try{	  
				Statement stmt= con.createStatement();
			   rs=stmt.executeQuery("select * from tickets where pnr="+pnr);
			  
			  rs.next();
			   dbpnr=rs.getInt(1);
			   source=rs.getString(2);
			   destination=rs.getString(3);
			   numofperson=rs.getInt(4);
			   date=rs.getString(5);
			   day=rs.getString(6);
			   hours=rs.getString(7);
			   distance=rs.getLong(8);
			   
			   con.close();
			} catch (Exception e) {
				System.out.println("connection or data interrupted");
				e.printStackTrace();
			}	
			}
			   
	
		public long lastpnr() throws SQLException
		{
		
			Statement stmt1=con.createStatement();
			   
			   rs1=stmt1.executeQuery("select pnr from tickets order by pnr desc limit 1");
			   
			  rs1.next();
			   pnr1 = rs1.getInt(1);
			   System.out.println(" hi curprob"+pnr1);
			  
			 // System.out.println(""+dbpnr+"	"+source+"	"+destination+"		"+numofperson+"		"+date);
			  con.close();
			  return pnr1;
			  		
	
	}

}
