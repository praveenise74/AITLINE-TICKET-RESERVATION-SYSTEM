package praveen.airline;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		
		String user = request.getParameter("user_name");
		String passwd = request.getParameter("password");
		
		DatabaseHandeler dh = new DatabaseHandeler();
		
		if(dh.insertData(user,passwd))
		{
			request.setAttribute("status1", "Access_Granted");
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
		else{
			request.setAttribute("status1", "login_unsuccessful");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
			//PrintWriter out= response.getWriter();
			//out.println("<font color=red>Either user name or password is wrong.</font>");
			//rd.include(request, response);
			
		}
		
		
	}

}
