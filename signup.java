package praveen.airline;

import java.sql.*;


public class signup {
	

	public int register(String name,String ph_num,String uid,String passwd)
	{
		boolean flag = false;
		int value=0;
		try{  
			//step1 load the driver class  
			Class.forName("com.mysql.jdbc.Driver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/airline","root","");    
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from users");  
			
			String id="";
			/*String nam="";
			String ph_nu="";
			String pass="";*/
			
			while(rs.next()) 
			{
				 id = rs.getString(1);
				 //nam = rs.getString(2);
				 //ph_nu = rs.getString(3);
				 //pass = rs.getString(4);
				if(uid.equals(id))
				{
					flag=true;}
				System.out.println("user alrady exist");  
			}
		
			
			if(flag==false)
			{
				String query = "insert into users values('"+uid+"','"+name+"','"+ph_num+"','"+passwd+"')";
				value = stmt.executeUpdate(query);
			}
			//if(value == 1)
			//	flag=true;
			  
			//step5 close the connection object  
			con.close(); 
			  }
		catch(Exception e){ System.out.println(e);}
		return value;  
}

	
	
	
}