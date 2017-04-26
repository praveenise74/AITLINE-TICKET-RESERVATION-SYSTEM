package praveen.airline;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
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
		/*String user = request.getParameter("user_name");
		String passwd = request.getParameter("password");
		
		DatabaseHandeler dh = new DatabaseHandeler();
		
		if(dh.insertData(user,passwd))
			request.setAttribute("login", "Access Granted");
		else
			request.setAttribute("login", "Access Denied");*/
		
		
		String name = request.getParameter("name");
		String ph_no = request.getParameter("phon_no.");
		String uid = request.getParameter("uid");
		String pass = request.getParameter("pass");
		
		signup su = new signup();
		
		 //su.verifyData ( uid , pass ); 

		
		
		request.setAttribute("user", user);
		request.setAttribute("pass", pass);
		
		request.getRequestDispatcher("print.jsp").forward(request, response);
	}

}
