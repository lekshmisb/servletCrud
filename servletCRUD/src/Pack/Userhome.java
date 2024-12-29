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
 * Servlet implementation class Userhome
 */
@WebServlet("/Userhome")
public class Userhome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userhome() {
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
        PrintWriter out=response.getWriter();
        
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        
        User uc=Userdao.checklogindetails(email, password);

        out.print("<h2>Hello "+uc.getFname()+"</h2>");
        out.print("<p>User id : "+uc.getId()+"</p>");
        out.print("<p>First name : "+uc.getFname()+"</p>");
  	    out.print("<p>Last name : "+uc.getLname()+"</p>");
  	    out.print("<p>State : "+uc.getState()+"</p>");
  	    out.print("<p>Email : "+uc.getEmail()+"</p>");
  	    out.print("<p>Password : "+uc.getPassword()+"</p>");
  	    out.print("<p>Utype : "+uc.getUtype()+"</p>");
        
      }

}
