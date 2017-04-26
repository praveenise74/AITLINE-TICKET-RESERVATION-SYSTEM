package praveen.airline;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
/**
 * Servlet implementation class flight_book
 */
@WebServlet("/Flight_book")
public class Flight_book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Flight_book() {
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
	
	
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		bstatus_database bd = new bstatus_database();
		long pnr=0;
		try {
			pnr = bd.lastpnr();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//int pnr=bd.pnr1;
		pnr++;
		String day="";
		
		String flight_id=request.getParameter("flight_id");
		int numofperson =Integer.parseInt(request.getParameter("numofperson"));
		String Date=request.getParameter("date");
		System.out.println(Date);

		  String input_date=Date;
		  SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
		  Date dt1;
		try {
			dt1 = format1.parse(input_date);
		
		  DateFormat format2=new SimpleDateFormat("EEEE"); 
		   day=format2.format(dt1);
		   System.out.println(day); 
		} catch (ParseException e) {
			System.out.println("Day is interrpted");
			e.printStackTrace();
		}
		/* SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         Date sDate=null;
		try {
			sDate = (Date) formatter.parse(request.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
				
		/*String input_date=Date;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		LocalDate date = LocalDate.parse(input_date, formatter); // LocalDate = 2010-02-23
		//Date uDate = java.sql.Date.valueOf(date);
		Date uDate = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		//java.util.Date uDate = new java.util.Date();
		//java.util.Date Date=(java.util.Date)request.getParameter("date").toDate();
		         System.out.println("Time in java.util.Date is : " + uDate);
		 
		         java.sql.Date sDate = convertUtilToSql(uDate);
		 
		         System.out.println("Time in java.sql.Date is : " + sDate);
		 
		         DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
		 
		         System.out.println("Using a dateFormat date is : " + df.format(uDate));
*/
		System.out.println("It worked here");
		fstatus_database fs1 = new fstatus_database();
		try {
			fs1.flightid(flight_id);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("exception occur at calling flightid");
			e.printStackTrace();
		}
		String source_city=fs1.source;
		String destination_city=fs1.destination;
		String hours=fs1.hours;
		long distance=fs1.distance;
		String day1=fs1.day;
		if(day1.compareToIgnoreCase(day)==0)
		{
		fbook_database fd=new fbook_database();
		
		if(fd.fbook(pnr,source_city, destination_city, numofperson, Date, day,hours,distance))
		{
			request.setAttribute("status2", pnr);
			
			System.out.println("ticket confirm your pnr number is :"+pnr);
	
		}		
		else{
			request.setAttribute("status2", "false");			
		}
		}
		else  {request.setAttribute("status2","daymismatch");}
		request.getRequestDispatcher("main.jsp").forward(request,response);

	//db.insert_date(sqlDate);
	}

}
