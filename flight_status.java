package praveen.airline;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class flight_status
 */
@WebServlet("/flight_status")
public class flight_status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public flight_status() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String date = request.getParameter("date");
		
		String input_date=date;
		String day=null;
		  SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
		  Date dt1;
		try {
			dt1 = format1.parse(input_date);
		
		  DateFormat format2=new SimpleDateFormat("EEEE"); 
		   day=format2.format(dt1);
		   System.out.println(day); 
		} catch (ParseException e) {
			System.out.println("Day is interrpted");
			e.printStackTrace();}
			System.out.println("working before reequest-1");
		fstatus_database fs = new fstatus_database();
		try {
			fs.fstatus(source,destination,day);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("working before reequest");
		request.setAttribute("flight_id",fs.flight_id);
		request.setAttribute("source1", fs.source);
		request.setAttribute("destination1", fs.destination);
		request.setAttribute("hours", fs.hours);
		request.setAttribute("distance", fs.distance);
		request.setAttribute("day", fs.day);
		if(fs.flight_id!=null)
		{
		request.setAttribute("status","true");
		System.out.println("working before main.jsp");
		}
		else
		{
			request.setAttribute("status","false");
		}
		
		request.getRequestDispatcher("main.jsp").forward(request,response);
		
		
		
	}

}

