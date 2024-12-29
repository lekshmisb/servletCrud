package Pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.Cookie;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        User u=new User();
        u.setId(Integer.parseInt(request.getParameter("id")));
        u.setFname(request.getParameter("fname"));
        u.setLname(request.getParameter("lname"));
        u.setState(request.getParameter("state"));
        u.setEmail(request.getParameter("email"));
        u.setPassword(request.getParameter("password"));
        
        int i=Userdao.updateUser(u);
        		
        if(i>0)		
        {
        	response.sendRedirect("Adminhome");
        		}
        else
        {
        	out.print("ERROR");
        }
        
	}

}
