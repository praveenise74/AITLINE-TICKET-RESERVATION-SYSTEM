package praveen.airline;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class book_status
 */
@WebServlet("/book_status")
public class book_status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public book_status() {
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
		
		long pnr =Long.parseLong(request.getParameter("pnr"));
		bstatus_database bs=new bstatus_database();
		
		 bs.bstatus(pnr);
		 request.setAttribute("dbpnr", bs.dbpnr);
		 request.setAttribute("source", bs.source);
		 request.setAttribute("destination", bs.destination);
		 request.setAttribute("numofperson", bs.numofperson);
		 request.setAttribute("date", bs.date);
		 request.setAttribute("day", bs.day);
		 request.setAttribute("hours", bs.hours);
		 request.setAttribute("distance",bs.distance);
		 if(bs.dbpnr>1000){
		 request.setAttribute("status1", "true");
		 }
		 
		 else
		 {
			 request.setAttribute("status1", "false");
		 }
		 
		 //RequestDispatcher dispatcher=request.getRequestDispatcher("main");
		 System.out.println("it worked here1");
		 System.out.println(bs.dbpnr);
		// System.out.println(date);
		// System.out.println(destination);
		 request.getRequestDispatcher("main.jsp").forward(request, response);
		
		
		
	}

}
