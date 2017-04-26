package praveen.airline;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		
		doGet(request, response);
		
		String name = request.getParameter("name");
		String ph_num = request.getParameter("phon_no.");
		String uid = request.getParameter("uid");
		String passwd = request.getParameter("pass");
		String passwd1 = request.getParameter("pass1");
		System.out.println(passwd+" "+passwd1);
		if(passwd.compareTo(passwd1)==0){
			
		
		signup ds =new signup();
		int value=ds.register(name,ph_num,uid,passwd);
		if(value>0)
		{
			request.setAttribute("status", "signup successful");
			//request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("status", "User Already Exists");
			//request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		}
		else{
			request.setAttribute("status", "Password Missmatch");
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

